package cn.jcex.view;

import android.os.Handler;
import android.os.Message;

/**
 * 类描述：自定义 anim.
 * 选择开关 动画
 * @author sunyaqin
 * @version 1.0
 * @date 2018/04/13 19:44
 */
public class FrameAnimationController {
	private static final int MSG_ANIMATE = 1000;

	public static final int ANIMATION_FRAME_DURATION = 1000 / 60;

	private static final Handler mHandler = new AnimationHandler();

	private FrameAnimationController() {
		throw new UnsupportedOperationException();
	}

	public static void requestAnimationFrame(Runnable runnable) {
		Message message = new Message();
		message.what = MSG_ANIMATE;
		message.obj = runnable;
		mHandler.sendMessageDelayed(message, ANIMATION_FRAME_DURATION);
	}

	public static void requestFrameDelay(Runnable runnable, long delay) {
		Message message = new Message();
		message.what = MSG_ANIMATE;
		message.obj = runnable;
		mHandler.sendMessageDelayed(message, delay);
	}

	private static class AnimationHandler extends Handler {
		public void handleMessage(Message m) {
			switch (m.what) {
			case MSG_ANIMATE:
				if (m.obj != null) {
					((Runnable) m.obj).run();
				}
				break;
			}
		}
	}
}
