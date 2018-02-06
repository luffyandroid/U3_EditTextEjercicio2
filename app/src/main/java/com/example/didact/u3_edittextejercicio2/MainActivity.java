package com.example.didact.u3_edittextejercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {

    Spinner spDia, spMes, spAno;
    EditText etNombre, etTelefono, etSueldo, etPrima, etTotal;
    Button btnIva;
    int prima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.et_nombre);
        etTelefono = (EditText)findViewById(R.id.et_telefono);
        etSueldo = (EditText)findViewById(R.id.et_sueldo);
        etPrima = (EditText)findViewById(R.id.et_prima);
        etTotal = (EditText)findViewById(R.id.et_total);
        spDia = (Spinner)findViewById(R.id.sp_dia);
        String[] dia={"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        ArrayAdapter<String> adaptadorDia = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,dia);
        spDia.setAdapter(adaptadorDia);
        spMes = (Spinner)findViewById(R.id.sp_mes);
        String[] mes={"","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Obtubre","Noviembre","Diciembre"};
        ArrayAdapter<String> adaptadorMes = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,mes);
        spMes.setAdapter(adaptadorMes);
        spAno = (Spinner)findViewById(R.id.sp_ano);
        String[] ano={"","2018","2017","2016","2015","2014","2013","2012","2011","2010"};
        ArrayAdapter<String> adaptadorAno = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,ano);
        spAno.setAdapter(adaptadorAno);
        btnIva = (Button)findViewById(R.id.btn_iva);

        prima=0;

    }

    public void clickIva(View view){
        String cajaSueldo =etSueldo.getText().toString();
        if (cajaSueldo.equals("")){

            Toast.makeText(getApplicationContext(),"Deber rellenar el sueldo",
                    Toast.LENGTH_LONG).show();

        }else{

            double sueldo = Double.parseDouble(cajaSueldo);
            double sueldoNuevo = sueldo - (sueldo*0.10);
            etSueldo.setText(sueldoNuevo+"");
            btnIva.setEnabled(false);
            etSueldo.setEnabled(false);
            btnIva.setText("Aplicado");

        }
    }

    public void clickMas(View view){
        //prima++; Sumar de 1 en 1
        if(prima<100){
            prima=prima+10;
            etPrima.setText(prima+"");
        }

    }

    public void clickMenos(View view){
        //prima--; Restar de 1 en 1
        if(prima>0){
            prima=prima-10;
            etPrima.setText(prima+"");
        }
    }

    public void clickCalcular(View view){

    }

    public void clickGenerar(View view){
        //Recoger el valor de la caja de texto Nombre
        String nombreCompleto = etNombre.getText().toString();

        //Comprobar si el nombre está vacio
        if(nombreCompleto.equals("") || nombreCompleto.length()==0){
            Toast.makeText(getApplicationContext(),"Deber rellenar con un nombre",
                    Toast.LENGTH_LONG).show();
        }else{
            //Split: devuelve un array de String sepataros por el valor que le demos
            String[] arraynombre = nombreCompleto.split(" ");
            //Si el arrayNombre tiene menos de 3 posiciones avisamos al usuario
            if (arraynombre.length<3){
                Toast.makeText(getApplicationContext(), "El formato del nombre no es correcto.\n" +
                        "Formato: Nombre Apellido1 Apellido2", Toast.LENGTH_SHORT).show();
            }else{
                int tamArray = arraynombre.length;
                String apellido2 = arraynombre[tamArray-1];
                String apellido1 = arraynombre[tamArray-2];

                int tamRestante = tamArray-2;
                String nombre="";
                for (int i=0; i<tamRestante; i++){
                    nombre+=arraynombre[i]+" ";
                }


                Toast.makeText(getApplicationContext(),
                        "Nombre: "+nombre+" Apellido1: "+apellido1+" Apellido2: "+apellido2,
                        Toast.LENGTH_LONG).show();

            }
        }

        //Comprobar telefono

        String cajaTelefono = etTelefono.getText().toString();
        if (cajaTelefono.equals("")){
            Toast.makeText(getApplicationContext(),"Debes de rellenar el telefono",
                    Toast.LENGTH_LONG).show();
        }else{
            //Convertir el valor String a int
            int telefono = Integer.parseInt(cajaTelefono);

            if (telefono<600000000 || telefono>999999999){
                Toast.makeText(getApplicationContext(),"Formato incorrecto, debe de comenzar por 6, 7, 8 o 9",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Telefono correcto "+telefono,
                        Toast.LENGTH_LONG).show();
            }
        }




    }



}
