package co.elytra.android.customization.picker

import android.app.Application;

import com.android.wallpaper.module.InjectorProvider;

import co.elytra.android.customization.module.ElytraThemePickerInjector;

public class ElytraCustomizationPickerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        InjectorProvider.setInjector(ElytraThemePickerInjector());
    }

}
