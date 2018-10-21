package nightlife.kumar.vikash.nightlife;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.UnderlineSpan;

/**
 * Created by vikash kumar on 19-12-2017.
 */

public class NoUnderlineSpan extends UnderlineSpan {

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setUnderlineText(false);
        ds.setColor(Color.parseColor("#000000"));
        }
}