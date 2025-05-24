package co.edu.uco.onlinetest.crosscutting.excepciones;

public class CrosscuttingOnlineTestException extends OnlineTestException {

    private static final long serialVersionUID = 3387516993124229948L;

    private CrosscuttingOnlineTestException(String mensajeUsuario, String mensajeTecnico, Exception exceptionRaiz) {
        super(mensajeUsuario, mensajeTecnico, exceptionRaiz, LayerException.CROSSCUTTING);
    }

    public static OnlineTestException reportar(String mensajeUsuario) {
        return new CrosscuttingOnlineTestException(mensajeUsuario,mensajeUsuario,new Exception());
    }


    public static OnlineTestException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new CrosscuttingOnlineTestException(mensajeUsuario,mensajeTecnico, new Exception());
    }



    public static OnlineTestException reportar(String mensajeUsuario, String mensajeTecnico, Exception exceptionRaiz) {
        return new CrosscuttingOnlineTestException(mensajeUsuario,mensajeTecnico,new Exception());
    }

}
