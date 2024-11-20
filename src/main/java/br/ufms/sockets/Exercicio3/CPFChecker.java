package br.ufms.sockets.Exercicio3;

public class CPFChecker {
    public static boolean check(String cpf){
        String inVerifierDigits = cpf.substring(9);
        String startDigits = cpf.substring(0, 9);

        return calculateVerifierDigits(startDigits.toCharArray()).equals(inVerifierDigits);
    }

    private static String calculateVerifierDigits(char[] chars){

        int checkSum, mod, modDiff;
        checkSum = 0;
        for(int i=0; i<chars.length; i++){
            int digit = Character.digit(chars[i], 10);
            if(digit == -1) return "false";

            int multiplier = (chars.length+1) - i;

            checkSum += digit*multiplier;
        }

        mod = checkSum % 11;
        int verifierDigitFirst = (modDiff = 11 - mod) >= 10 ? 0 : modDiff;

        if(chars.length < 10){
            String newChars = String.copyValueOf(chars)+String.valueOf(verifierDigitFirst);
            return String.valueOf(verifierDigitFirst)+calculateVerifierDigits(newChars.toCharArray());
        }

        return String.valueOf(verifierDigitFirst);
    }


}
