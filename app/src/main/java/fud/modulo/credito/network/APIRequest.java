package fud.modulo.credito.network;

import fud.modulo.credito.pojo.SuccesCreditDataPOJO;
import fud.modulo.credito.pojo.ValidateCreditDataPOJO;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIRequest {

      @FormUrlEncoded
      @POST("validateCredit")
      Call<ValidateCreditDataPOJO> getCredit  (@Field("customers_id") String customers_id);

      @FormUrlEncoded
      @POST("successCredit")
      Call<SuccesCreditDataPOJO> getSuccess(@Field("quantity") String quantity);

}
