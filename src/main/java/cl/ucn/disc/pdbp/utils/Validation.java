package cl.ucn.disc.pdbp.utils;
import java.util.regex.Pattern;

@SuppressWarnings({"UtilityClass", "UtilityClassCanBeEnum"})
public final class Validation {

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
    private static final String REGEX = "^(([(]?(\\d{2,4})[)]?)|(\\d{2,4})|([+1-9]+\\d{1,2}))?[-\\s]?(\\d{2,3})?[-\\s]?((\\d{7,8})|(\\d{3,4}[-\\s]\\d{3,4}))$";
    /**
     * The regular expression compiled.
     */
    private static final Pattern PATTERN = Pattern.compile(REGEX);
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

    public static boolean isPhoneValid(String numero) {
        if(numero==null){
            return false;
        }
        return PATTERN.matcher(numero).find();
    }

    public static boolean isDireccionValid(String movil) {
        return false;
    }

    public static boolean isEmailValid(String movil) {
        return false;
    }

    /**

    public static boolean isEmailValid(String movil) {
        String expresion = "^[-\\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\\.){1,125}[A-Z]{2,63}$";
    }
    */
}
