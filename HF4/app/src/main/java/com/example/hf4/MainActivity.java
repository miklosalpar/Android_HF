package com.example.hf4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Currency> currencyList = createCurrencyData();

        ListView listView = findViewById(R.id.list_view_currencies);

        CurrencyAdapter adapter = new CurrencyAdapter(this, currencyList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Currency selectedCurrency = (Currency) parent.getItemAtPosition(position);

                String message = selectedCurrency.getCode() + " - Pénznem: " + selectedCurrency.getName() + "\n" +
                        "Vételár: " + selectedCurrency.getBuyingRate() + " RON\n" +
                        "Eladási ár: " + selectedCurrency.getSellingRate() + " RON";

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
    private List<Currency> createCurrencyData() {
        List<Currency> list = new ArrayList<>();

        list.add(new Currency("EUR", "Euro", R.drawable.download, "4,4100", "4,5500"));
        list.add(new Currency("USD", "Dolar american", R.drawable.usa, "3,9750", "4,1450"));
        list.add(new Currency("GBP", "Lira sterlina", R.drawable.uk, "6,1250", "6,3550"));
        list.add(new Currency("AUD", "Dolar australian", R.drawable.ausztral, "2,9600", "3,0600"));
        list.add(new Currency("CAD", "Dolar canadian", R.drawable.kanada, "3,0950", "3,2650"));
        list.add(new Currency("CHF", "Franc elvetian", R.drawable.svajc, "4,2300", "4,3300"));
        list.add(new Currency("DKK", "Coroana daneza", R.drawable.dan, "0,5850", "0,6150"));
        list.add(new Currency("HUF", "Forint maghiar", R.drawable.magyar, "0,0136", "0,0146"));
        return list;
    }
}