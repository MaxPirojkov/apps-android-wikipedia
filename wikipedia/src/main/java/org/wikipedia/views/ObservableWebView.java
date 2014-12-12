package org.wikipedia.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import org.wikipedia.WikipediaApp;
import org.wikipedia.events.WebViewInvalidateEvent;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

public class ObservableWebView extends WebView {
    private static final WebViewInvalidateEvent INVALIDATE_EVENT = new WebViewInvalidateEvent();

    private List<OnScrollChangeListener> onScrollChangeListeners;
    private List<OnDownMotionEventListener> onDownMotionEventListeners;
    private List<OnUpOrCancelMotionEventListener> onUpOrCancelMotionEventListeners;
    private List<OnContentHeightChangedListener> onContentHeightChangedListeners;

    private int contentHeight = 0;

    public void addOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        onScrollChangeListeners.add(onScrollChangeListener);
    }

    public void addOnDownMotionEventListener(OnDownMotionEventListener onDownMotionEventListener) {
        onDownMotionEventListeners.add(onDownMotionEventListener);
    }

    public void addOnUpOrCancelMotionEventListener(OnUpOrCancelMotionEventListener onUpOrCancelMotionEventListener) {
        onUpOrCancelMotionEventListeners.add(onUpOrCancelMotionEventListener);
    }

    public void addOnContentHeightChangedListener(OnContentHeightChangedListener onContentHeightChangedListener) {
        onContentHeightChangedListeners.add(onContentHeightChangedListener);
    }

    public interface OnScrollChangeListener {
        void onScrollChanged(int oldScrollY, int scrollY);
    }

    public interface  OnDownMotionEventListener {
        void onDownMotionEvent();
    }

    public interface OnUpOrCancelMotionEventListener {
        void onUpOrCancelMotionEvent();
    }

    public interface OnContentHeightChangedListener {
        void onContentHeightChanged(int contentHeight);
    }

    public ObservableWebView(Context context) {
        super(context);
        init();
    }

    public ObservableWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ObservableWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ObservableWebView(Context context, AttributeSet attrs, int defStyle, boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
        init();
    }

    private void init() {
        onScrollChangeListeners = new ArrayList<OnScrollChangeListener>();
        onDownMotionEventListeners = new ArrayList<OnDownMotionEventListener>();
        onUpOrCancelMotionEventListeners = new ArrayList<OnUpOrCancelMotionEventListener>();
        onContentHeightChangedListeners = new ArrayList<OnContentHeightChangedListener>();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        for (OnScrollChangeListener listener : onScrollChangeListeners) {
            listener.onScrollChanged(oldt, t);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (onDownMotionEventListeners.size() > 0 && onUpOrCancelMotionEventListeners.size() > 0) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    for (OnDownMotionEventListener listener : onDownMotionEventListeners) {
                        listener.onDownMotionEvent();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    for (OnUpOrCancelMotionEventListener listener : onUpOrCancelMotionEventListeners) {
                        listener.onUpOrCancelMotionEvent();
                    }
                    break;
                default:
                    // Do nothing for all the other things
                    break;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            return;
        }
        if (contentHeight != getContentHeight()) {
            contentHeight = getContentHeight();
            for (OnContentHeightChangedListener listener : onContentHeightChangedListeners) {
                listener.onContentHeightChanged(contentHeight);
            }
        }
        WikipediaApp.getInstance().getBus().post(INVALIDATE_EVENT);
    }
}
