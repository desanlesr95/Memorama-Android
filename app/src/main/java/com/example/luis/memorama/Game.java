package com.example.luis.memorama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class Game extends AppCompatActivity implements View.OnClickListener{
    Button button[];
    EditText editText;
    TextView textView;
    Button comemzar;
    String nombre;
    int aleatorio[];
    int aleatorio2[];
    int volteadas=0;
    int par[];
    int puntos=0;
    boolean presionado[];
    String etiquetas[]={"< !DOCTYPE>","< html>","< title>","< body>","< h1> to <h6>","< p>","< br>","< hr>","< !--...-->"," <b>","< i>",
            "< strong>","< sub>","< sup>","< form>","< input>","< textarea>","< button>","< select>","< option>","< label>","< fieldset>","< iframe>"
            ,"< img>","< map>","< area>","< a>","< link>","< nav>","< ul>","< ol>","< li>","< table>","< caption>","< th>","< tr>","< td>","< thead>"
            ,"< tbody>","< style>","< div>","< span>","< header>","< footer>","< main>","< section>","< article>","< aside>","< head>","< meta>"
            ,"< script>"};
    String definiciones[]={"Define el tipo de documento","Define un documento html","Define el titulo del documento",
            "Define el cuerpo del documento","Define encabezados","Define un parrafo","Inserta un salto de linea","Inserta un linea horizontal"
            ,"Define un comentario","Define el texto en negritas","Define una parte del texto en una voz o estado de ánimo alternativo",
            "Define texto importante","Define el texto con subindices","Define el texto con superindices","Define un formulario",
            "Define un contro de entrada","Define un control de entrada multilínea","Define un boton","Define una lista desplegable"
            ,"Define una opcion en la lista desplegable","Define una etiqueta para un elemento input",
            "Grupos de elementos relacionados en un formulario","Define un marco en línea","Define una imagen",
            "Define un mapa de imagen del lado del cliente","Define un área dentro de un mapa de imágenes","Define un hipervinculo"
            ,"Define la relación entre un documento y un recurso externo (más utilizado para vincular a hojas de estilo)"
            ,"Define vínculos de navegación","Define una lista no ordenada","Define una lista ordenada","Define un elemento de una lista"
            ,"Define una tabla","Define un titulo de tabla","Define una celda de encabezado en una tabla","Define una fila en una tabla"
            ,"Define una celda en una tabla","Agrupa el contenido del encabezado en una tabla","Agrupa el contenido del encabezado en una tabla"
            ,"Agrupa el contenido del cuerpo en una tabla","Define la información de estilo de un documento","Define una seccion en un documento"
            ,"Define una seccion en un documento","Define un encabezado para un documento o sección","Define un pie de página para un documento o sección"
            ,"Especifica el contenido principal de un documento","Define una seccion en un documento","Define un articulo"
            ,"Define el contenido aparte del contenido de la página","Define información sobre el documento","Define metadatos sobre un documento HTML"
            ,"Define un script a lado del cleinte"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        button=new Button[12];
        button[0]=(Button)findViewById(R.id.b0);
        button[1]=(Button)findViewById(R.id.b1);
        button[2]=(Button)findViewById(R.id.b2);
        button[3]=(Button)findViewById(R.id.b3);
        button[4]=(Button)findViewById(R.id.b4);
        button[5]=(Button)findViewById(R.id.b5);
        button[6]=(Button)findViewById(R.id.b6);
        button[7]=(Button)findViewById(R.id.b7);
        button[8]=(Button)findViewById(R.id.b8);
        button[9]=(Button)findViewById(R.id.b9);
        button[10]=(Button)findViewById(R.id.b10);
        button[11]=(Button)findViewById(R.id.b11);
        editText=(EditText)findViewById(R.id.nombre);
        textView=(TextView)findViewById(R.id.puntos);
        comemzar=(Button)findViewById(R.id.comenzar);
        comemzar.setOnClickListener(this);
        par=new int[2];
        q=new int[2];
    }

    public void empezar(){
        for (int i=0;i<12;i++){
            button[i].setOnClickListener(this);
            button[i].setTextSize(6);
        }
        aleatorio=new int[6];
        aleatorio2=new int[6];
        presionado=new boolean[12];
        for(int i=0;i<6;i++) {
            aleatorio[i]=(int)(Math.floor((Math.random() * etiquetas.length)));
            aleatorio2[i]=aleatorio[i];
        }
        for(int i=0;i<12;i++) {
            presionado[i]=false;
        }
    }
    int q[];
    public void voletar(int boton,int x){
        if(volteadas==2){
            volteadas=0;
            for(int i=0;i<par.length;i++) {
                button[par[i]].setText("");
                presionado[par[i]]=false;
            }
            par[volteadas]=boton;
            q[volteadas]=x;
            volteadas++;
        }
        else{
            par[volteadas]=boton;
            q[volteadas]=x;
            volteadas++;
            if(volteadas==2) {
                if(q[0]==q[1]){
                    for(int i=0;i<par.length;i++) {
                        button[par[i]].setBackgroundResource(R.color.colorPrimary);
                    }
                    volteadas=0;
                    puntos++;
                    textView.setText(nombre+" Puntos: "+puntos);
                }
            }
            presionado[boton]=true;

        }
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.comenzar:
                empezar();
                nombre=editText.getText().toString();
                textView.setText(nombre+" Puntos: "+puntos);
                break;
            case R.id.b0:
                if(!presionado[0]){
                    button[0].setText(etiquetas[aleatorio[0]]);
                    voletar(0,0);
                }
                break;
            case R.id.b1:
                if(!presionado[1]){
                    button[1].setText(definiciones[aleatorio2[0]]);
                    voletar(1,0);
                }
                break;
            case R.id.b2:
                if(!presionado[2]){
                    button[2].setText(etiquetas[aleatorio[2]]);
                    voletar(2,2);
                }
                break;
            case R.id.b3:
                if(!presionado[3]){
                    button[3].setText(definiciones[aleatorio2[1]]);
                    voletar(3,1);
                }
                break;
            case R.id.b4:
                if(!presionado[4]){
                    button[4].setText(etiquetas[aleatorio[3]]);
                    voletar(4,3);
                }
                break;
            case R.id.b5:
                if(!presionado[5]){
                    button[5].setText(definiciones[aleatorio2[2]]);
                    voletar(5,2);
                }
                break;
            case R.id.b6:
                if(!presionado[6]){
                    button[6].setText(definiciones[aleatorio2[3]]);
                    voletar(6,3);
                }
                break;
            case R.id.b7:
                if(!presionado[7]){
                    button[7].setText(etiquetas[aleatorio[4]]);
                    voletar(7,4);
                }
                break;
            case R.id.b8:
                if(!presionado[8]){
                    button[8].setText(definiciones[aleatorio2[5]]);
                    voletar(8,5);
                }
                break;
            case R.id.b9:
                if(!presionado[9]){
                    button[9].setText(etiquetas[aleatorio[5]]);
                    voletar(9,5);
                }
                break;
            case R.id.b10:
                if(!presionado[10]){
                    button[10].setText(definiciones[aleatorio2[4]]);
                    voletar(10,4);
                }
                break;
            case R.id.b11:
                if(!presionado[11]){
                    button[11].setText(etiquetas[aleatorio[1]]);
                    voletar(11,1);
                }
                break;
        }
    }
}