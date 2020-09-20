/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.repository.base;

import ir.tourism.tit.darya.model.base.BaseEntity;
import ir.tourism.tit.darya.model.base.Column;
import ir.tourism.tit.darya.model.base.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.management.ReflectionException;
import javax.validation.constraints.NotNull;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

@Repository
public class CRUDRepository<T extends BaseEntity> implements CRUDRepositoryInterface<T> {

    //prefix for every parameter in stored procedures
    public static final String PARAM_PREFIX = "p_";
    //out parameter name which returns the id
    public static final String ID_OUT_PARAM_NAME = "id";
    //out parameter which returns a result set
    public static final String RESULT_SET_OUT_PARAM_NAME = "result_out";
    //prefix for find by stored procedures
    public static final String FIND_BY_PROPERTY_PREFIX = "BY_";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public T create(T entity) throws SQLException, ReflectionException {

        if (entity == null) {
            throw new IllegalArgumentException("Can not create null entity to database");
        }

        //creating method call string
        Map<String, Object> inParams = getSaveParameters(entity, DBOperation.CREATE);
        List<String> outParams = new ArrayList<>();
        outParams.add(PARAM_PREFIX + ID_OUT_PARAM_NAME);
        int paramsSize = 0;
        if (inParams != null) {
            paramsSize += inParams.size();
        }
        paramsSize += outParams.size();
        String call = getStoredProcedureCall(DBOperation.CREATE, null, paramsSize);

        //executing stored procedure
        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection(); CallableStatement callableStatement = connection.prepareCall(call)) {

            //inserting input parameters
            setCallInParameters(callableStatement, inParams);
            //setting output parameters to get id of new created row in database
            callableStatement.registerOutParameter(PARAM_PREFIX + ID_OUT_PARAM_NAME, Types.NUMERIC);
            callableStatement.execute();
            //genertaing new Object
            Long id = callableStatement.getLong(PARAM_PREFIX + ID_OUT_PARAM_NAME);
            Optional<T> newObject = readById(id);
            if (newObject.isPresent())
                return newObject.get();
            else {
                throw new SQLException("Could not find new row in database");
            }
        }
    }

    @Override
    public Iterable<T> createAll(Iterable<T> entities) throws SQLException, ReflectionException {
        if (entities == null) {
            throw new IllegalArgumentException("List of entities to be created is null");
        }
        List<T> result = new ArrayList<>();
        for (T entity : entities) {
            if (entity == null) {
                throw new IllegalArgumentException("Can not create null entity to database");
            }
            T newEntity = create(entity);
            result.add(newEntity);
        }

        return result;
    }

    @Override
    public T update(T entity) throws SQLException, ReflectionException {
        if (entity == null) {
            throw new IllegalArgumentException("An entity can not be null");
        }
        //creating method call string
        Map<String, Object> inParams = getSaveParameters(entity, DBOperation.UPDATE);
        int paramsSize = 0;
        if (inParams != null) {
            paramsSize += inParams.size();
        }
        String call = getStoredProcedureCall(DBOperation.UPDATE, null, paramsSize);

        //executing stored procedure
        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection(); CallableStatement callableStatement = connection.prepareCall(call)) {

            //inserting input parameters
            setCallInParameters(callableStatement, inParams);
            //setting output parameters to get id of updated row in database


            callableStatement.executeUpdate();
            Long id = entity.getId();

            //genertaing updated
            Optional<T> newObject = readById(id);
            if (newObject.isPresent())
                return newObject.get();
            else {
                throw new SQLException("Could not find updated row in database");
            }
        }
    }

    @Override
    public Iterable<T> updateAll(Iterable<T> entities) throws SQLException, ReflectionException {
        if (entities == null) {
            throw new IllegalArgumentException("List of entities to be updated is null");
        }
        List<T> result = new ArrayList<>();
        for (T entity : entities) {
            if (entity == null) {
                throw new IllegalArgumentException("Can not update null entity.");
            }
            T newEntity = update(entity);
            result.add(newEntity);
        }
        return result;
    }

    @Override
    public void delete(@NotNull T entity) throws SQLException, ReflectionException {
        Map<String, Object> inParams = new HashMap<>();
        inParams.put(PARAM_PREFIX + "id", entity.getId());
        String call =  getStoredProcedureCall(DBOperation.DELETE, null, inParams.size());

        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection(); CallableStatement callableStatement = connection.prepareCall(call)) {
            setCallInParameters(callableStatement, inParams);
            callableStatement.execute();
        }
    }

    @Override
    public void deleteAll(Iterable<T> entities) throws SQLException, ReflectionException {
        if (entities == null) {
            throw new IllegalArgumentException("List of entities to be updated is null");
        }
        for (T entity : entities) {
            if (entity == null) {
                throw new IllegalArgumentException("Can not update null entity.");
            }
            delete(entity);
        }
    }

    @Override
    public Optional<T> readById(Long id) throws SQLException, ReflectionException {
        if (id == null) {
            throw new IllegalArgumentException("Id can not be null");
        }
        Map<String, Object> inParams = new HashMap<>();
        inParams.put(PARAM_PREFIX + "id", id);
        List<String> outParams = new ArrayList<>();
        outParams.add(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME);
        int paramsSize = inParams.size();
        paramsSize += outParams.size();
        String call =  getStoredProcedureCall(DBOperation.FIND, FIND_BY_PROPERTY_PREFIX + "ID", paramsSize);

        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection(); CallableStatement callableStatement = connection.prepareCall(call)) {
            setCallInParameters(callableStatement, inParams);
            callableStatement.registerOutParameter(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME, Types.REF_CURSOR);
            callableStatement.execute();
            ResultSet resultSet = (ResultSet)callableStatement.getObject(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME);
            Iterator<T> iterator = resultSetToIterable(resultSet).iterator();
            if (iterator.hasNext()) {
                return Optional.of(iterator.next());
            }
            return Optional.empty();
        }
    }

    @Override
    public boolean existsById(Long id) throws SQLException, ReflectionException {
        if (id == null) {
            throw new IllegalArgumentException("Id can not be null");
        }
        Optional<T> result = readById(id);
        return result.isPresent();
    }

    @Override
    public Iterable<T> readAll() throws SQLException, ReflectionException {
        List<String> outParams = new ArrayList<>();
        outParams.add(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME);

        String call = getStoredProcedureCall(DBOperation.FIND, "ALL", outParams.size());
        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection(); CallableStatement callableStatement = connection.prepareCall(call)) {
            callableStatement.registerOutParameter(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME, Types.REF_CURSOR);
            callableStatement.execute();
            ResultSet resultSet = (ResultSet)callableStatement.getObject(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME);
            return resultSetToIterable(resultSet);
        }
    }

    @Override
    public Iterable<T> readByProperty(String propertyName, Object searchParam) throws SQLException, ReflectionException {
        if (propertyName == null || propertyName.isEmpty()) {
            throw new IllegalArgumentException("Property name can not be null");
        }
        if (searchParam == null) {
            throw new IllegalArgumentException("Search parameter can not be null");
        }
        Field field = null;
        try {
            Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
            Class<T> clazz = (Class<T>) types[0];
            List<Field> fields = getAllFields(new ArrayList<Field>(), clazz);
            field = getField(fields, propertyName);
        } catch (NoSuchFieldException exp) {
            throw new ReflectionException(exp);
        }
        if (field.isAnnotationPresent(Column.class)) {
            String colName = field.getAnnotation(Column.class).name();
            Map<String, Object> inParams = new HashMap<>();
            inParams.put(PARAM_PREFIX + colName.toLowerCase(), searchParam);
            List<String> outParams = new ArrayList<>();
            outParams.add(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME);
            int paramsSize = inParams.size();
            paramsSize += outParams.size();
            String call = getStoredProcedureCall(DBOperation.FIND, FIND_BY_PROPERTY_PREFIX + colName, paramsSize);

            try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection(); CallableStatement callableStatement = connection.prepareCall(call)) {
                setCallInParameters(callableStatement, inParams);
                callableStatement.registerOutParameter(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME, Types.REF_CURSOR);
                callableStatement.execute();
                ResultSet resultSet = (ResultSet) callableStatement.getObject(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME);
                return resultSetToIterable(resultSet);
            }
        } else {
            throw new IllegalArgumentException("invalid field or column name");
        }

    }

    @Override
    public long count() throws SQLException {
        //@TODO
        //count stored Procedure
        return 0;
    }

    /**
     * Retrieves all declared fields of a given type, including fields of all super classes.
     * @param fields an empty list of fields.
     * @param type type which we want to retrieve fields.
     * @return list of all declared fields.
     */
    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    /**
     * Finds a field with a given name in a list of Field objects.
     * @param fields list of fields
     * @param fieldName name of fields
     * @return Field object
     * @throws NoSuchFieldException if the field is not found in list.
     */
    public static Field getField(List<Field> fields, String fieldName) throws NoSuchFieldException {
        for (Field field : fields) {
            if (field.getName().equals(fieldName))
                return field;
        }
        throw new NoSuchFieldException("Field not found: " + fieldName);
    }


    /**
     * Converts the input resultset to an Iterable of the managed type. The resultset is generated after a query on the appropriate table of managed type.
     * @param resultSet the resultset to be converted. Must not be null.
     * @return Iterable of the managed type. Never will be null.
     * @throws IllegalArgumentException if the resultset is null.
     */
    public Iterable<T> resultSetToIterable(ResultSet resultSet) throws SQLException, ReflectionException {
        if (resultSet == null) {
            throw new IllegalArgumentException("Resultset is null.");
        }
        try {
            Set<T> result = new HashSet<>();
            Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
            Class<T> clazz = (Class<T>)types[0];
            Constructor<T> constructor = clazz.getConstructor();
            while (resultSet.next()) {
                T entity = constructor.newInstance();
                List<Field> declaredFields = getAllFields(new LinkedList<Field>(), clazz);
                for (Field field : declaredFields) {
                    if (field.isAnnotationPresent(Column.class)) {
                        String colName = field.getAnnotation(Column.class).name();
                        if (hasColumn(resultSet, colName)) {
                            Object fieldValue = resultSet.getObject(colName, field.getType());
                            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), entity.getClass());
                            Method setter = pd.getWriteMethod();
                            setter.invoke(entity, fieldValue);
                        }
                    }
                }
                result.add(entity);
            }
            return result;
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | IntrospectionException exp) {
            throw new ReflectionException(exp);
        }
    }

    /**
     * Checks whether a given resultset has a specified column.
     * @param resultSet input resultset
     * @param columnName name of the column to be searched.
     * @return true if the column exists, false otherwise.
     * @throws SQLException in case the operation on database is not successful.
     */
    public static boolean hasColumn(ResultSet resultSet, String columnName) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columns = metaData.getColumnCount();
        for (int ind = 1; ind <= columns; ind++) {
            if (columnName.equals(metaData.getColumnName(ind))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Given an input entity, depending of operation, returns the fields which should be saved as a Map of field name and field value.
     * @param entity the entity we want to add or update
     * @param operation the database operation which will be done.
     * @return Map of qualified fields.
     * @throws IllegalArgumentException in case entity is null
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    public Map<String, Object> getSaveParameters(@NotNull T entity, DBOperation operation) throws ReflectionException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity can not be null");
        } else {
            Map<String, Object> result = new HashMap<>();
            List<Field> allFields = getAllFields(new ArrayList<>(), entity.getClass());
            if (operation == DBOperation.UPDATE) {
                try {
                    Field idField = getField(allFields, "id");
                    String columnName = idField.getAnnotation(Column.class).name();
                    result.put(PARAM_PREFIX + columnName.toLowerCase(), entity.getId());
                } catch (NoSuchFieldException exp) {
                    throw new ReflectionException(exp);
                }
            }
            for (Field field : allFields) {
                if (field.isAnnotationPresent(Column.class)) {
                    if ((operation == DBOperation.CREATE && field.getAnnotation(Column.class).insertable()) ||
                            (operation == DBOperation.UPDATE && field.getAnnotation(Column.class).updatable())) {
                        try {
                            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), entity.getClass());
                            Method getter = pd.getReadMethod();
                            Object fieldValue = getter.invoke(entity);
                            String columnName = field.getAnnotation(Column.class).name();
                            result.put(PARAM_PREFIX + columnName.toLowerCase(), fieldValue);
                        } catch (IllegalAccessException | IntrospectionException | InvocationTargetException exp) {
                            throw new ReflectionException(exp);
                        }
                    }
                }
            }
            return result;
        }
    }

    /**
     * Creates a string to be called by database, according to operation, sub operation and count of parameters. It uses the @Entity annotation of
     * managed entity to retrieve the table name and appropriate stored procedures names.
     * @param operation the database operation
     * @param subOperation the sub operation for Find operations
     * @param paramsSize total size of input and output parameters
     * @return a callable string
     */
    public String getStoredProcedureCall(@NotNull DBOperation operation, String subOperation, @NotNull int paramsSize) {
        StringBuffer call = new StringBuffer();
        call.append("{CALL ");
        Type[] types = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
        if (types.length > 0) {
            Entity table = (Entity)((Class<T>)types[0]).getDeclaredAnnotation(Entity.class);
            if (table != null) {
                call.append(table.tableName());
            }
        }
        if (operation != null) {
            call.append("_").append(operation.getName());
            if (subOperation != null && !subOperation.isEmpty()) {
                call.append("_").append(subOperation);
            }
        }

        call.append("(");
        if (paramsSize > 0) {
            for (int ind=0; ind<paramsSize; ind++) {
                call.append("?");
                if (ind < paramsSize - 1) {
                    call.append(",");
                }
            }
        }
        call.append(")}");
        return call.toString();
    }

    /**
     * Sets the input parameters for a given CallableStatement.
     * @param callableStatement the statement to be called
     * @param inParams Map of input param names and values.
     * @throws SQLException in case the operation on database is not successful.
     */
    public void setCallInParameters(CallableStatement callableStatement, Map<String, Object> inParams) throws SQLException {

        if ((callableStatement != null) && (inParams != null)) {
            for (Map.Entry<String, Object> entry : inParams.entrySet()) {
                /**
                 * @Todo
                 * Write callableStatement.setFelan for All DataType that we using in project
                 */
                if (entry.getValue() instanceof java.util.Date)
                    callableStatement.setDate(entry.getKey(), new java.sql.Date(((java.util.Date) entry.getValue()).getTime()));
                else
                    callableStatement.setObject(entry.getKey(), entry.getValue());
            }
        }

    }

    @Override
    public Iterable<T> callStoredProcedure(String spName, HashMap<String,Object> inParams,boolean hasOutParam) throws SQLException, ReflectionException {
        StringBuilder call = new StringBuilder();
        call.append("{ call " + spName + "(");
        //append inParams
        if (!inParams.isEmpty()) {
            for (Object ignored : inParams.values()) {
                call.append("?,");
            }
        }
        //append outParam
        if(hasOutParam)
          call.append("?) }");
        else{
            int i=call.lastIndexOf(",");
            call.deleteCharAt(i);
            call.append(") }");
        }
        String query = call.toString();
        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            setCallInParameters(callableStatement, inParams);
            if(hasOutParam)
              callableStatement.registerOutParameter(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME, Types.REF_CURSOR);
            callableStatement.execute();
            if(hasOutParam) {
                ResultSet resultSet = (ResultSet) callableStatement.getObject(PARAM_PREFIX + RESULT_SET_OUT_PARAM_NAME);
                return resultSetToIterable(resultSet);
            }
            return null;
        }
    }

}