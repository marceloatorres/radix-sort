package com.company;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        String string = "";
        for(int i = 0; i < n; i++){
            string += c;
        }
        return string;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String s, int n, char c)
    {
        String string = replicate(c,n);
        String aux = s;
        while(aux.length() < string.length()){
            aux = c + aux;
        }

        return aux;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String arrString[] = new String[arr.length];
        for(int i = 0; i< arr.length; i++){
            arrString[i] = String.valueOf(arr[i]);
        }
        return arrString;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        return null;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int maxAux = arr[0].length();

        for(int i = 1; i < arr.length; i++){
            if(arr[i].length() > maxAux){
                maxAux = arr[i].length();
            }
        }
        return maxAux;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c)
    {
        int maxCh = maxLength(arr);
        for(int i = 0; i < arr.length; i++){
            arr[i] = lpad(arr[i],maxCh, c);
        }
    }
}