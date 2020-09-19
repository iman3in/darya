/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.controller.response;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TITResponseCode {

    SUCCESS("SUCCESS", 0, "Request was executed successfully."),
    INVALID_INPUT_ERROR("INVALID_INPUT_ERROR", 2, "Validation error(s) occurred"),
    DATABASE_ERROR("DATABASE_ERROR", 3, "Database error occurred."),
    INTERNAL_ERROR("INTERNAL_ERROR", 4, "Internal server error occurred.");

    /**
     * name of response code
     */
    private String name;

    /**
     * code number of response code
     */
    private int code;

    /**
     * message for this response code
     */
    private String message;

    TITResponseCode(String name, int code, String message) {
        this.name = name;
        this.code = code;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

}
