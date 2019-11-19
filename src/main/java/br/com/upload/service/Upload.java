package br.com.upload.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Upload {

    @Value("${upload.disco.diretorio-fotos}")
    private String destino;

    public void salvar(MultipartFile file) {
        this.salvarArquivo(file);
    }

    private void salvarArquivo(MultipartFile file) {

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(this.destino + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
