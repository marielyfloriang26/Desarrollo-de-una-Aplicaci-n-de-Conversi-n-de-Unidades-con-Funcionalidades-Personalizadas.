package com.example.conversionunidadestarea1;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import android.content.res.Configuration;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView tvSaludo;
    private EditText etNombre;
    private TextView tvVisor;

    private Button btnLongitud;
    private Button btnPeso;
    private Button btnTemp;

    private String entradaActual = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSaludo = findViewById(R.id.tvSaludo);
        etNombre = findViewById(R.id.etNombre);
        tvVisor = findViewById(R.id.tvVisor);

        btnLongitud = findViewById(R.id.btnLongitud);
        btnPeso = findViewById(R.id.btnPeso);
        btnTemp = findViewById(R.id.btnTemp);

        SwitchCompat switchModoOscuro = findViewById(R.id.switchModoOscuro);

        // Detecta si el emulador ya esta en modo oscuro
        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
            switchModoOscuro.setChecked(true);
        }

        // Evento para alternar el tema al presionar el switch
        switchModoOscuro.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        // Validación en tiempo real del campo nombre
        etNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String nombre = s.toString().trim();
                if (!nombre.isEmpty()) {
                    tvSaludo.setText("¡Hola, " + nombre + "!");
                    habilitarBotonesConversion(true);
                } else {
                    tvSaludo.setText("¡Bienvenido/a!");
                    habilitarBotonesConversion(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        configurarTecladoNumerico();
        configurarConversiones();
    }

    private void habilitarBotonesConversion(boolean estado) {
        btnLongitud.setEnabled(estado);
        btnPeso.setEnabled(estado);
        btnTemp.setEnabled(estado);
    }

    private void configurarTecladoNumerico() {
        int[] idsBotones = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnPunto
        };

        View.OnClickListener listenerNumeros = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button boton = (Button) v;
                String valor = boton.getText().toString();

                if (valor.equals(".") && entradaActual.contains(".")) {
                    return;
                }

                if (entradaActual.equals("0") && !valor.equals(".")) {
                    entradaActual = valor;
                } else {
                    entradaActual += valor;
                }

                tvVisor.setText(entradaActual);
            }
        };

        for (int id : idsBotones) {
            findViewById(id).setOnClickListener(listenerNumeros);
        }

        findViewById(R.id.btnReiniciar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarApp();
            }
        });
    }

    private void configurarConversiones() {
        btnLongitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double valor = Double.parseDouble(entradaActual);
                    double resultado = valor * 3.28084;
                    tvVisor.setText(String.format("%.2f m = %.2f ft", valor, resultado));
                    entradaActual = "";
                } catch (Exception e) {
                    tvVisor.setText("Error");
                }
            }
        });

        btnPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double valor = Double.parseDouble(entradaActual);
                    double resultado = valor * 2.20462;
                    tvVisor.setText(String.format("%.2f kg = %.2f lb", valor, resultado));
                    entradaActual = "";
                } catch (Exception e) {
                    tvVisor.setText("Error");
                }
            }
        });

        btnTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double valor = Double.parseDouble(entradaActual);
                    double resultado = (valor * 9 / 5) + 32;
                    tvVisor.setText(String.format("%.1f °C = %.1f °F", valor, resultado));
                    entradaActual = "";
                } catch (Exception e) {
                    tvVisor.setText("Error");
                }
            }
        });
    }

    private void reiniciarApp() {
        entradaActual = "";
        tvVisor.setText("0");
    }
}