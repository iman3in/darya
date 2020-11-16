/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.common;

import org.modelmapper.ModelMapper;

public class Singletons {
    private static Singletons singletons;
    private static ModelMapper modelMapper;
    private static Validator validator;

    private Singletons() {
    }

    public static Singletons getInstance(){
        if (singletons == null)
            singletons = new Singletons();
        return singletons;
    }

    public static ModelMapper getModelMapper(){
        if (modelMapper == null)
            modelMapper = new ModelMapper();
        return modelMapper;
    }

    public static Validator getValidator(){
        if (validator == null)
            validator = new Validator();
        return validator;
    }

}
