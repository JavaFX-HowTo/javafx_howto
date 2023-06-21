import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javafx.concurrent.Worker;
import javafx.scene.Node;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class LogArea
{
    private HTMLEditor editor;
    
    public Node getNode()
    {
        if (editor == null)
        {
            this.init();
        }
        return editor;
    }    

    private void init()
    {
        editor = new HTMLEditor();

        // 设置添加文本时自动下拉
        {
            WebView webView = (WebView) editor.lookup("WebView");
            WebEngine webEngine = webView.getEngine();
            webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == Worker.State.SUCCEEDED) {
                    webEngine.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                }
            });
        }
        
        // 隐藏工具栏
        {
            editor.setVisible(false);
            Set<Node> nodes = editor.lookupAll(".tool-bar");
            for(Node node : nodes)
            {
                node.setVisible(false);
                node.setManaged(false);
            }
            editor.setVisible(true);
        }
    }

    private static String curTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        return dtf.format(LocalDateTime.now());
    }

    public void logInfo(String message)
    {
        editor.setHtmlText(editor.getHtmlText() + String.format("<span>[%s]: %s</span>", curTime(), message) + "<br/>");
    }

    public void logError(String message)
    {
        editor.setHtmlText(editor.getHtmlText() + String.format("<span>[%s]: <span style=\"color: red\">%s</span></span>", curTime(), message) + "<br/>");
    }

    public void clear()
    {
        editor.setHtmlText("");
    }

    public String getHTMLText()
    {
        return editor.getHtmlText();
    }
}

