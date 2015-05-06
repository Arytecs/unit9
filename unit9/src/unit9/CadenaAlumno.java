/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit9;

/**
 *
 * @author Araceli Teruel
 */
public class CadenaAlumno {
    /**
     *Función que dice si dos cadenas son iguales o no
     * @param cadena1
     * @param cadena2
     * @return true:si son iguales. 
     *         false: si no lo son
     */
    public static boolean sonIguales(String cadena1, String cadena2)
    {
        if(cadena1.length()!=cadena2.length())
            return false;
        
        char[] vector1=cadena1.toCharArray();
        char[] vector2=cadena2.toCharArray();
        int contador=0, tamanyo=cadena1.length();
        
        for(int i=0;i<cadena1.length();i++)
        {
            if(vector1[i]==vector2[i])
                contador++;
        }
        
        if(contador==tamanyo)
            return true;
        else
            return false;
    }
    
    /**
     *Método que compara dos cadenas y te indica si la primera de ellas es mayor o no.
     * @param cadena1
     * @param cadena2
     * @return true: si es mayor la primera cadena.
     *         false: en caso contrario.
     */
    public static boolean esMayor(String cadena1, String cadena2)
    {
        char[] vector1=cadena1.toCharArray();
        char[] vector2=cadena2.toCharArray();
        int tamanyo1=cadena1.length();
        int tamanyo2=cadena2.length();
        int tamanyo=tamanyo1;
        
        if(tamanyo1>tamanyo2)
            return true;
        else if(tamanyo1<tamanyo2)
            return false;
        
        boolean mayor=false;
        boolean menor=false;
        for(int i=0;i<tamanyo && mayor==false && menor==false;i++)
        {
            if(vector1[i]>vector2[i])
                mayor=true;
            else if(vector1[i]<vector2[i])
                menor=true;
        }
        return mayor;
    }
    
    /**
     *Método que compara dos cadenas y te indica si la primera de ellas es menor o no.
     * @param cadena1
     * @param cadena2
     * @return true: si es menor la primera cadena.
     *         false: en caso contrario.
     */
    public static boolean esMenor(String cadena1, String cadena2)
    {
        if(esMayor(cadena1, cadena2) || sonIguales(cadena1, cadena2))
            return false;
        else
            return true;
    }
    
    /**
     *Método que compara dos cadenas y te dice si son iguales ignorando las mayúsculas que pueda haber.
     * @param cadena1
     * @param cadena2
     * @return true: si las cadenas son iguales.
     *         false: en caso contrario.
     */
    public static boolean comparaIgnorandoMayusculas(String cadena1, String cadena2)
    {
        char[] vector1=cadena1.toCharArray();
        char[] vector2=cadena2.toCharArray();
        
        String resultado1="";
        String resultado2="";
        if(vector1.length<vector2.length || vector2.length<vector1.length)
            return false;
        for(int i=0;i<vector1.length;i++)
        {
            if((int) vector1[i]>=65 && (int) vector1[i]<=90)
                vector1[i]=(char) ((int) vector1[i]+32);
            if((int) vector2[i]>=65 && (int) vector2[i]<=90)
                vector2[i]=(char) ((int) vector2[i]+32);
            
            resultado1+=vector1[i];
            resultado2+=vector2[i];
        }
        
        return sonIguales(resultado1, resultado2);
    }
    
    /**
     *Método que reemplaza la parte de la cadena deseada por otra cosa que el usuario indique.
     * @param cadena: String que se desea reemplazar
     * @param regla: String que es la parte de la cadena que queremos reemplazar
     * @param cambio: Regla de cambio.
     * @return cadena reemplazada
     */
    public static String reemplazaTodos(String cadena, String regla, String cambio)
    {
        char[] vector=cadena.toCharArray();
        char[] vector_regla=regla.toCharArray();
        char[] vector_cambio=cambio.toCharArray();
        
        int[] posiciones1=new int[vector.length];
        
        int cont=0;
        int cont2=0;
        String resultado="";
        
        //Buscamos las posiciones en las que queremos el cambio
        for(int i=0;i<vector.length-vector_regla.length;i++)
        {
            for(int j=0;j<vector_regla.length;j++)
            {
                if(vector[i+j]==vector_regla[j])
                    cont++;
            }
            if(cont==vector_regla.length)
            {
                posiciones1[cont2]=i;
                cont2++;
            }
            cont=0;
        }
        
        //Definimos el nuevo vector cambiando las letras deseadas
        for(int i=0;i<cont2;i++)
        {
            for(int j=0;j<vector_cambio.length;j++)
            {
                vector[posiciones1[i]+j]=vector_cambio[j];
            }
        }
        for(int i=cont2;i<=vector_regla.length;i++)
        {
            vector[i]=vector[i+vector_regla.length-1];
        }
        
        //Guardamos ese vector ya cambiado en un String
        for(int i=0;i<vector.length-vector_regla.length+vector_cambio.length;i++)
        {
            resultado+=vector[i];
        }
        
        return resultado;
    }
    
    /**
     *Método que reemplaza el primer string encontrado mediante el cambio que elija el usuario
     * @param cadena
     * @param regla
     * @param cambio
     * @return cadena reemplazada.
     */
    public static String reemplazaPrimero(String cadena, String regla, String cambio)
    {
        char[] vector=cadena.toCharArray();
        char[] vector_regla=regla.toCharArray();
        char[] vector_cambio=cambio.toCharArray();
        
        int posicion=0, cont=0;
        String resultado="";
        
        for(int i=0;i<vector.length-vector_regla.length+1;i++)
        {
            for(int j=0;j<vector_regla.length;j++)
            {
                if(vector[i+j]==vector_regla[j])
                    cont++;
                else
                    break;
            }
            if(cont==vector_regla.length)
            {
                posicion=i;
                break;
            }
            cont=0;
        }
        if(cont==0)
            return cadena;
        
        for(int j=0;j<vector_cambio.length;j++)
        {
            vector[posicion+j]=vector_cambio[j];
        }
        for(int i=posicion+1;i<=vector_regla.length;i++)
        {
            vector[i]=vector[i+vector_regla.length-1];
        }
        for(int i=0;i<vector.length-vector_regla.length+vector_cambio.length;i++)
        {
            resultado+=vector[i];
        }
        
        return resultado;
    }
    
    /**
     *Método que devuelve un string sin espacios previos/posteriores.
     * @param cadena
     * @return string sin los espacios
     */
    public static String quitaEspacios(String cadena)
    {
        char[] vector=cadena.toCharArray();
        char[] resultado=new char[vector.length];
        int cont=0;
        String devolucion="";
        for(int i=0;i<vector.length;i++)
        {
            if(vector[i]!=' ')
            {
                resultado[cont]=vector[i];
                cont++;
            }
        }
        
        for(int i=0;i<cont;i++)
        {
            devolucion+=resultado[i];
        }
        return devolucion;
    }
    
    /**
     *Método que convierte una cadena en mayúsculas
     * @param cadena
     * @return string en mayúsculas
     */
    public static String convertirMayusculas(String cadena)
    {
        char[] vector=cadena.toCharArray();
        char[] vector2=new char[vector.length];
        String resultado="";
        
        for(int i=0;i<vector.length;i++)
        {
            if((int) vector[i]>=97 && (int) vector[i]<=122)
                vector2[i]=(char) ((int) vector[i]-32);
            else
                vector2[i]=vector[i];
            
            resultado+=vector2[i];
        }
        return resultado;
    }
    
    /**
     *Método qeu convierte una cadena en minúsculas
     * @param cadena
     * @return string en minúsculas
     */
    public static String convertirMinusculas(String cadena)
    {
        char[] vector=cadena.toCharArray();
        char[] vector2=new char[vector.length];
        String resultado="";
        
        for(int i=0;i<vector.length;i++)
        {
            if((int) vector[i]>=65 && (int) vector[i]<=90)
                vector2[i]=(char) ((int) vector[i]+32);
            else
                vector2[i]=vector[i];
            
            resultado+=vector2[i];
        }
        return resultado;
    }
    
    /**
     *Método que te devuelve la longitud de una cadena
     * @param cadena
     * @return longitud de la cadena
     */
    public static long longitudCadena(String cadena)
    {
        return cadena.length();
    }
    
    /**
     *Método que te dice si una cadena empieza por un prefijo dado
     * @param cadena
     * @param prefijo
     * @return true: si la cadena empieza por dicho prefijo.
     *         false: en caso contrario.
     */
    public static boolean empiezaCon(String cadena, String prefijo)
    {
        char[] vector_cadena=cadena.toCharArray();
        char[] vector_prefijo=prefijo.toCharArray();
        int cont=0;
        
        for(int i=0;i<vector_prefijo.length;i++)
        {
            if(vector_cadena[i]==vector_prefijo[i])
                cont++;
        }
        if(cont==vector_prefijo.length)
            return true;
        else
            return false;
    }
    
    /**
     *Método que te dice si una cadena acaba por el sufijo deseado
     * @param cadena
     * @param sufijo
     * @return true: si la cadena acaba por dicho sufijo.
     *         false: en caso contrario.
     */
    public static boolean acabaEn(String cadena, String sufijo)
    {
        char[] vector_cadena=cadena.toCharArray();
        char[] vector_sufijo=sufijo.toCharArray();
        int cont=0;
        
        for(int i=vector_cadena.length-vector_sufijo.length;i<vector_cadena.length;i++)
        {
            if(vector_cadena[i]==vector_sufijo[i-(vector_cadena.length-vector_sufijo.length)])
                cont++;
        }
        if(cont==vector_sufijo.length)
            return true;
        else
            return false;
    }
    
    /**
     *Método que te devuelve la posicion en la que se encuentra por primera vez un string deseado
     * @param cadena
     * @param letra
     * @return long con la posicion.
     */
    public static long posicionPrimeraCadena(String cadena, String letra)
    {
        char[] vector=cadena.toCharArray();
        char[] vector_letra=letra.toCharArray();
        int cont=0;
        
        for(int i=0;i<vector.length-vector_letra.length+1;i++)
        {
            for(int j=0;j<vector_letra.length;j++)
            {
                if(vector[i+j]==vector_letra[j])
                    cont++;
            }
            if(cont==vector_letra.length)
                return i;
            else
                cont=0;
        }
        return -1;
    }
    
    /**
     *Método que te devuelve un String sacado de otro a partir de una posicion
     * @param cadena
     * @param posicionInicio
     * @return String
     */
    public static String extraerSubstring(String cadena, int posicionInicio)
    {
        char[] vector=cadena.toCharArray();
        String resultado="";
        
        for(int i=posicionInicio;i<vector.length;i++)
            resultado+=vector[i];
        return resultado;
    }
    
    /**
     *Método que te devuelve un String sacado de otro a partir de una posicion hasta otra posicion
     * @param cadena
     * @param posicionInicio
     * @param posicionFinal
     * @return String
     */
    public static String extraerSubstring(String cadena, int posicionInicio, int posicionFinal)
    {
        char[] vector=cadena.toCharArray();
        String resultado="";
        
        for(int i=posicionInicio;i<posicionFinal;i++)
            resultado+=vector[i];
        return resultado;
    }
    
    /**
     *método el cual te concatena dos cadenas usando el operando +
     * @param cadena1
     * @param cadena2
     * @return String con las dos cadenas unidas.
     */
    public static String concatenaCadenas(String cadena1, String cadena2)
    {
        return cadena1+cadena2;
    }
}
