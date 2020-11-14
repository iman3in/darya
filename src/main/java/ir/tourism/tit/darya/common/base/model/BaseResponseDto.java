/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.common.base.model;

public class BaseResponseDto {
    private String message;

    public BaseResponseDto() {
    }

    public BaseResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
