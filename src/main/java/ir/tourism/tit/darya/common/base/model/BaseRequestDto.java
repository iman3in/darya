/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.common.base.model;

public class BaseRequestDto {
    private String aaToken;

    public BaseRequestDto() {
    }

    public BaseRequestDto(String aaToken) {
        this.aaToken = aaToken;
    }

    public String getAaToken() {
        return aaToken;
    }

    public void setAaToken(String aaToken) {
        this.aaToken = aaToken;
    }
}
