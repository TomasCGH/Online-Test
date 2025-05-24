package co.edu.uco.onlinetest.crosscutting.excepciones;

public class BusinessLogicOnlineTestException extends OnlineTestException {

    private static final long serialVersionUID = 3387516993124229948L;

    private BusinessLogicOnlineTestException(String mensajeUsuario, String mensajeTecnico, Exception exceptionRaiz) {
        super(mensajeUsuario, mensajeTecnico, exceptionRaiz, LayerException.BUSINESS_LOGIC);
    }

    public static OnlineTestException reportar(String mensajeUsuario) {
        return new BusinessLogicOnlineTestException(mensajeUsuario,mensajeUsuario,new Exception());
    }


    public static OnlineTestException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new BusinessLogicOnlineTestException(mensajeUsuario,mensajeTecnico, new Exception());
    }



    public static OnlineTestException reportar(String mensajeUsuario, String mensajeTecnico, Exception exceptionRaiz) {
        return new BusinessLogicOnlineTestException(mensajeUsuario,mensajeTecnico,new Exception());
    }

}
