package com.test.titamedia.titamediatest.client.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {

    @Schema(description = "document number client", example = "1234")
    private String documentNumber;
    @Schema(description = "document type client", example = "CC")
    private String documentType;
    @Schema(description = "name client", example = "Pepito")
    private String name;

}
