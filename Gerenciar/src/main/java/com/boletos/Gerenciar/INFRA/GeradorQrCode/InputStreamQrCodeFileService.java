package com.boletos.Gerenciar.INFRA.GeradorQrCode;

import com.boletos.Gerenciar.SERVICE.GeradorQrCode.GeradorQrCodeService;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class InputStreamQrCodeFileService implements GeradorQrCodeService {

    @Override
    public InputStream gerar(String codigo) {
        var code = QRCode.from(codigo).withSize(250, 250).stream();
        ByteArrayInputStream bis = new ByteArrayInputStream(code.toByteArray());
        return bis;
    }
}
