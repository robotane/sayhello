package com.robotane.sayhello.service;

import static java.io.File.createTempFile;

import com.my.company.file.bucket.BucketComponent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HelloService {
  private final BucketComponent bucketComponent;

  @SneakyThrows
  public String uploadHelloMessage(String name) {
    var fileSuffix = ".txt";
    var filePrefix = "hello-" + name;
    var bucketKey = filePrefix + fileSuffix;
    var fileToUpload = createTempFile(filePrefix, fileSuffix);
    writeMessageIntoFile("Hey! Hello, " + name + " !", fileToUpload);
    bucketComponent.upload(fileToUpload, bucketKey);
    return bucketComponent.presign(bucketKey, Duration.ofMinutes(5)).toString();
  }

  private void writeMessageIntoFile(String message, File file) throws IOException {
    FileWriter writer = new FileWriter(file);
    writer.write(message);
    writer.close();
  }
}
