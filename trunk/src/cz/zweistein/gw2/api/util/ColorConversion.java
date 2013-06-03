package cz.zweistein.gw2.api.util;

import java.awt.Color;

import cz.zweistein.gw2.api.dto.ColorHue;

public class ColorConversion {

	public static String getRgbColor(ColorHue color) {

		if (color == null) {
			return String.format("#%06X", (0xFFFFFF & new Color(255, 255, 255).getRGB()));
		}

		// 1) Take the base (RGB) color
		int[] baseRgb = new int[] { 128, 26, 26 };

		// 2) Apply brightness and contrast
		for (int i = 0; i < 3; i++) {
			baseRgb[i] = (int) (((baseRgb[i] + color.getBrightness()) - 128) * color.getContrast() + 128);
		}

		// 3) Convert color to HSL space
		float[] hsl = Color.RGBtoHSB(baseRgb[0], baseRgb[1], baseRgb[2], null);

		// 4) Apply HSL shift
		hsl[0] = (float) (color.getHue() / 360);
		hsl[1] = (float) (hsl[1] * color.getSaturation());
		hsl[2] = (float) (hsl[2] * color.getLightness());

		// 5) Convert color back to RGB space (this is the final color value)
		int rgb = Color.HSBtoRGB(hsl[0], hsl[1], hsl[2]);

		return String.format("#%06X", (0xFFFFFF & rgb));
	}
}
