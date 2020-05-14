/*
MIT License

Copyright (c) [2020] [Wilber Mauricio Navarro Moreira].

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package cl.ucn.disc.pdbp.utils;
import java.util.regex.Pattern;

/**
 * Validation Class.
 * @autor Wilber Navarro.
 */
public final class Validation {
    /**
     *
     */
    private Validation() {
    }
/**
 /**
 *  http://www.forosdelweb.com/f45/validar-rut-rol-unico-tributario-textfield-java-953486/
 *
 //
    public static boolean isRutValid(String rut){
        if(rut==null){
            return false;
        }
        if(rut.length()>0){
            String[] rut_dv=rut.split("-");
            if(rut_dv.length==2){
                try{
                    int rut_i=Integer.parseInt( rut_dv[0] );
                    char dv=rut_dv[1].charAt(0);
                    if(ValidarRut(rut_i,dv)){
                        return true;
                    }else{
                        return false;
                    }
                }
                catch( Exception ex )
                {
                    System.out.println(" Error " + ex.getMessage());
                }
            }

        }
        return false;


    }*/
    @SuppressWarnings("MethodWithMultipleReturnPoints")
    public static boolean isRutValid(String rut){
        if(rut==null){
            return false;
        }
        if(rut.length()>0){

            String rut_s=rut.substring(0,rut.length()-1);
            char dv=rut.charAt(rut.length()-1);
            int rut_i=0;
            try{
                rut_i=Integer.parseInt( rut_s);
            }catch (Exception ex){
                return false;
            }


            if (!Pattern.matches("[0-9]+", rut_s)) {
                return false;
            }

            return ValidarRut(rut_i,dv);

        }
        return false;
    }

    /**
     * the regular expression.
     * -https://stackoverrun.com/es/q/543170.
     */
    private static final String REGEX = "^(([(]?(\\d{2,4})[)]?)|(\\d{2,4})|([+1-9]+\\d{1,2}))?[-\\s]?(\\d{2,3})?[-\\s]?((\\d{7,8})|(\\d{3,4}[-\\s]\\d{3,4}))$";

    /**
     * the regular expression     *.
     */
    private static final String DIR = "^[A-z]+(\\s[A-z]+)*\\s\\d+";

    /**
     * the regular expression.
     * - https://howtodoinjava.com/regex/java-regex-validate-email-address/.
     */
    private static final String EMA = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";//"^[-\\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\\.){1,125}[A-Z]{2,63}$";

    /**
     * The regular expression compiled.
     */
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    /**
     * The regular expression compiled.
     */
    private static final Pattern DIRECCION = Pattern.compile(DIR);

    /**
     * The regular expression compiled.
     */
    private static final Pattern CORREO = Pattern.compile(EMA);
    /*
     *
     * Fuente : http://www.creations.cl/2009/01/generador-de-rut-y-validador/
     */
    @SuppressWarnings({"ValueOfIncrementOrDecrementUsed", "BooleanMethodNameMustStartWithQuestion", "OverlyComplexArithmeticExpression", "AssignmentToMethodParameter", "ForLoopWithMissingComponent", "StandardVariableNames"})
    public static boolean ValidarRut(int rut, char dv)
    {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10)
        {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }

    /**
     *
     * @param numero fijo o movil de la persona.
     * @return true if number is valid.
     */
    public static boolean isPhoneValid(String numero) {
        if(numero==null){
            return false;
        }
        return PATTERN.matcher(numero).find();
    }

    /**
     *
     * @param direccion .
     * @return true if direccion is valid.
     */
    public static boolean isDireccionValid(String direccion) {
        if(direccion==null){
            return false;
        }
        return DIRECCION.matcher(direccion).find();
    }

    /**
     *
     * @param email .
     * @return true if email is valid.
     */
    public static boolean isEmailValid(String email) {
        if(email==null){
            return false;
        }
        return CORREO.matcher(email).find();
    }

    /**

    public static boolean isEmailValid(String movil) {
        String expresion = "^[-\\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\\.){1,125}[A-Z]{2,63}$";
    }
    */

}
