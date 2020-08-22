/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.controller.response;

public class TITResponseBody {

    private TITResponseCode responseCode;
    private Object data;

    public TITResponseBody() {
        super();
    }

    public TITResponseBody(TITResponseCode responseCode, Object data) {
        this.responseCode = responseCode;
        this.data = data;
    }

    /**
     * Returns the response code for this response body
     * @return response code
     */
    public TITResponseCode getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the response code for this response body
     * @param responseCode response code
     */
    public void setResponseCode(TITResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * Returns the data object of this response body
     * @return data object
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets the data object of this response body
     * @param data data object
     */
    public void setData(Object data) {
        this.data = data;
    }
}
