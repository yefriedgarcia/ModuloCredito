package fud.modulo.credito.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ValidateCreditDataPOJO {
    @SerializedName("message")
    @Expose
    private String message; // mensaje al usuario
    @SerializedName("success")
    @Expose
    private String success; // 1 si la conexion fue exitosa;
    @SerializedName("data")
    @Expose
    private ValidateCreditDetailsPOJO data = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ValidateCreditDetailsPOJO getData() {
        return data;
    }

    public void setData(ValidateCreditDetailsPOJO data) {
        this.data = data;
    }
}
