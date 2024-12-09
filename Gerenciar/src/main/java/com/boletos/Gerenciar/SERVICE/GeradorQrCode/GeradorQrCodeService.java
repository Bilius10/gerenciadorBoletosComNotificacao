package com.boletos.Gerenciar.SERVICE.GeradorQrCode;

import java.io.InputStream;

public interface GeradorQrCodeService {

    InputStream gerar(String codigo);
}
