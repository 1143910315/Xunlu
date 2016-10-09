package promote;
public class Pxunlu {
	class xldata {
		public int		x;
		public int		y;
		public xldata	previous;
	}
	
	class xlhc {
		public xldata	data;
		public xlhc		previous;
	}

	private int			mapwidth;
	private int			mapheight;
	private int			originleft	= 0;
	private int			origintop	= 0;
	private boolean[][]	ditu;

	/**
	 * 构造函数，创建一个地图大小。
	 *
	 * @author 林嘉豪
	 * @param width
	 *            判断时（0，0）可用，而坐标（width，0）不可用。
	 * @param height
	 *            判断时（0，0）可用，而坐标（0，height）不可用。
	 */
	public Pxunlu(int width, int height) {
		ditu = new boolean[width][height];
		mapwidth = width;
		mapheight = height;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				ditu[i][j] = false;
			}
		}
	}
	
	/**
	 * 添加一个矩形不可达区域，即返回的寻路路径不经过此区域。
	 *
	 * @param left
	 *            不可达区域的横坐标。
	 * @param top
	 *            不可达区域的纵坐标。
	 * @param width
	 *            不可达区域的宽度。
	 * @param height
	 *            不可达区域的高度。
	 */
	public void addobstacle(int left, int top, int width, int height) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (i + left < mapwidth && j + top < mapheight && i + left >= 0 && j + top >= 0) {
					ditu[i + left][j + top] = true;
				}
			}
		}
	}
	
	/**
	 * 设置寻路起点，未设置起点按坐标（0,0）处理。
	 *
	 * @param left
	 *            寻路起点的横坐标。
	 * @param top
	 *            寻路起点的纵坐标。
	 */
	public void setorigin(int left, int top) {
		originleft = left;
		origintop = top;
	}
	
	/**
	 * 开始寻路。
	 *
	 * @param left
	 *            寻路终点的横坐标。
	 * @param top
	 *            寻路终点的纵坐标。
	 */
	public void xunlu(int left, int top) {
		// 声明
		xlhc inactivity = null;
		xlhc active = null;
		xldata temp;
		boolean[][] map = ditu.clone();
		int l;
		int t;
		// 初始化数据
		l = originleft;
		t = origintop;
		if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
			active = new xlhc();
			temp = new xldata();
			temp.x = l;
			temp.y = t;
			active.data = temp;
			if (l == left && t == top) {
				return;
			}
		}
		while (active != null || inactivity != null) {
			xlhc lian = new xlhc();
			while (active != null) {
				temp = active.data;
				l = temp.x - 1;
				t = temp.y;
				if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
					lian.data = new xldata();
				}
			}
		}
	}
}
