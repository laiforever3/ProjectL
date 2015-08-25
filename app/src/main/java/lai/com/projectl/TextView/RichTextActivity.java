package lai.com.projectl.TextView;

import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextPaint;
import android.text.Html.TagHandler;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import lai.com.projectl.R;

public class RichTextActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich_text);
        initHtml();
    }

    private void initHtml() {
        String html = "<h1>html测试标题1</h1><h2>html测试标题2</h2><h3>html测试标题3</h3>"
                + "<p><i>这是斜体</i><br>  <strong>这是粗体</strong><br>  <strong><i>这是斜体加粗体<url>自定义点击事件可以用于跳转<img ></url></i></strong><br></p>"
                + "<p><u>这是下划线</u><br>  这是[微笑]<br><font color=red>这是红色的颜色</p></font>"
                + "<a href=\"http://www.dreamdu.com/xhtml/\">超链接HTML入门</a><p><url>自定义点击事件可以用于跳转></url></p>";

        CharSequence trimmed = trimTrailingWhitespace(Html.fromHtml(html, null, new MyTagHandler(this)));
        SpannableStringBuilder builder = new SpannableStringBuilder(trimmed);
        TextViewFixTouchConsume tvHtml = (TextViewFixTouchConsume) findViewById(R.id.tvHtml);
        tvHtml.setText(builder);
        tvHtml.setMovementMethod(TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
    }

    private class MyTagHandler implements TagHandler {

        private int sIndex = 0;
        private int eIndex = 0;
        private Context mContext;

        public MyTagHandler(Context context) {
            mContext = context;
        }

        @Override
        public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
            if (tag.toLowerCase().equals("url")) {
                if (opening) {
                    sIndex = output.length();
                } else {
                    eIndex = output.length();
                    output.setSpan(new MxgsaSpan(output), sIndex, eIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }

        private class MxgsaSpan extends ClickableSpan {

            Editable output;

            public MxgsaSpan(Editable output) {
                this.output = output;
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(Color.RED);
                ds.setUnderlineText(false); //去掉下划线
            }

            @Override
            public void onClick(View widget) {
                // 具体代码，可以是跳转页面，可以是弹出对话框，下面是跳转页面
                Toast.makeText(mContext, "onclick", Toast.LENGTH_SHORT).show();
            }

        }

    }


    //html的数据，采用Html.fromHtml转成CharSequence形式，会出现在末尾加上俩个\n换行。
    //把换行去掉
    public static CharSequence trimTrailingWhitespace(CharSequence source) {
        try {
            if (source == null)
                return "";

            int i = source.length();

            // loop back to the first non-whitespace character
            while (--i >= 0 && Character.isWhitespace(source.charAt(i))) {
            }

            return source.subSequence(0, i + 1);
        } catch (Exception e) {
            e.printStackTrace();
            return source;
        }

    }


}
