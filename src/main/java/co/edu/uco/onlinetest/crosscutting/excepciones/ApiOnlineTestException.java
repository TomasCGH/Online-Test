package co.edu.uco.onlinetest.crosscutting.excepciones;

public class ApiOnlineTestException extends OnlineTestException {

    private static final long serialVersionUID = 3387516993124229948L;

    private ApiOnlineTestException(String mensajeUsuario, String mensajeTecnico, Exception exceptionRaiz) {
        super(mensajeUsuario, mensajeTecnico, exceptionRaiz, LayerException.API);
    }

    public static OnlineTestException reportar(String mensajeUsuario) {
        return new ApiOnlineTestException(mensajeUsuario,mensajeUsuario,new Exception());
    }


    public static OnlineTestException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new ApiOnlineTestException(mensajeUsuario,mensajeTecnico, new Exception());
    }



    public static OnlineTestException reportar(String mensajeUsuario, String mensajeTecnico, Exception exceptionRaiz) {
        return new ApiOnlineTestException(mensajeUsuario,mensajeTecnico,new Exception());
    }

}
