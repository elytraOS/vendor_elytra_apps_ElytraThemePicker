package co.elytra.android.customization.module

import android.app.Activity

import android.content.Context

import androidx.fragment.app.Fragment

import com.android.wallpaper.model.WallpaperInfo
import com.android.wallpaper.module.CustomizationSections
import com.android.wallpaper.picker.MonetPreviewFragment

import com.android.customization.module.ThemePickerInjector

public class ElytraThemePickerInjector : ThemePickerInjector() {

    private var customizationSections: CustomizationSections? = null

    override fun getPreviewFragment(
            context: Context,
            wallpaperInfo: WallpaperInfo,
            mode: Int,
            viewAsHome: Boolean,
            viewFullScreen: Boolean,
            testingModeEnabled: Boolean): Fragment {
        return MonetPreviewFragment.newInstance(wallpaperInfo, mode, viewAsHome, viewFullScreen, testingModeEnabled);
    }

    override fun getCustomizationSections(activity: Activity): CustomizationSections {
        return customizationSections
            ?: ElytraCustomizationSections(
                    getKeyguardQuickAffordancePickerInteractor(activity),
                    getKeyguardQuickAffordancePickerViewModelFactory(activity)
                )
                .also { customizationSections = it }
    }
}
