/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api;

import com.metriport.api.core.ClientOptions;
import com.metriport.api.core.Suppliers;
import com.metriport.api.resources.medical.MedicalClient;
import java.util.function.Supplier;

public class Metriport {
    protected final ClientOptions clientOptions;

    protected final Supplier<MedicalClient> medicalClient;

    public Metriport(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.medicalClient = Suppliers.memoize(() -> new MedicalClient(clientOptions));
    }

    public MedicalClient medical() {
        return this.medicalClient.get();
    }

    public static MetriportBuilder builder() {
        return new MetriportBuilder();
    }
}
