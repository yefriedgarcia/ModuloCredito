package fud.modulo.credito.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;

import java.text.DecimalFormat;

import fud.modulo.credito.R;
import fud.modulo.credito.models.CreditInteractorImpl;
import fud.modulo.credito.presenter.CreditPresenter;
import fud.modulo.credito.presenter.PresenterCreditImpl;
import fud.modulo.credito.views.CreditViews;

public class MainActivity extends AppCompatActivity implements CreditViews  {
    TextView min, max, cost,total, amount, date;
    CreditPresenter creditPresenter;
    CrystalSeekbar rangeSeekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        min = findViewById(R.id.monto_min);
        max = findViewById(R.id.monto_max);
        cost = findViewById(R.id.costo);
        total = findViewById(R.id.total);
        amount = findViewById(R.id.amount);
        date = findViewById(R.id.date);

        rangeSeekbar = findViewById(R.id.filter_amount_slider);

        creditPresenter = new PresenterCreditImpl(this, new CreditInteractorImpl());

        rangeSeekbar.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
            @Override
            public void valueChanged(Number value) {
                amount.setText(String.valueOf(value));
                creditPresenter.validatePrestamo(String.valueOf(value));

            }
        });
    }

    @Override
    public void setValuesDefault(String vMin, String vMax) {
        amount.setText(String.valueOf(vMin));
        rangeSeekbar.setSteps(Float.parseFloat("1000"));
        rangeSeekbar.setMinValue(Float.parseFloat(vMin));
        rangeSeekbar.setMaxValue(Float.parseFloat(vMax));
        rangeSeekbar.setMinStartValue(Float.parseFloat(vMin));

        min.setText(vMin);
        max.setText(vMax);

    }

    @Override
    public void setUpdateQuantity(double res) {
        total.setText(String.format("$%s", new DecimalFormat("###,###.00").format(res)));
    }

    @Override
    public void setUpdateTax(double res) {
        cost.setText(String.format("$%s", new DecimalFormat("###,###.00").format(res)));
    }

    @Override
    public void setUpdateDate(String date) {
       this.date.setText(date);
    }

    @Override
    public void navigateToHome() {
        Log.d("mTAG", "setUpdateQuantity: 4");
    }

}