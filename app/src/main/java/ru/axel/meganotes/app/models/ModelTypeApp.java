package ru.axel.meganotes.app.models;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;

public class ModelTypeApp {

    private String mNameApp;
    private GoogleMaterial.Icon mIco;

    public String getNameApp() {
        return mNameApp;
    }

    public GoogleMaterial.Icon getIco() {
        return mIco;
    }

    public ModelTypeApp(String nameApp, GoogleMaterial.Icon ico) {
        this.mNameApp = nameApp;
        this.mIco = ico;
    }
}
