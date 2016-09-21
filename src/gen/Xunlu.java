package gen;
public class Xunlu {
	class lu {
		public int	x;
		public int	y;
		public lu	previous	= null;
	}

	class lian {
		public lu	data;
		public lian	next	= null;
		/**
		 * 1左2右3上4下0出错
		 */
		public byte	direction;
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
	public Xunlu(int width, int height) {
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
		boolean[][] map = ditu.clone();
		lian head;
		lian htwo;
		lu one;
		lian temp;
		head = new lian();
		int l;
		int t;
		byte d;
		// 初始化数据
		l = originleft - 1;
		t = origintop;
		d = 1;
		if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
			map[l][t] = true;
			one = new lu();
			one.x = l;
			one.y = t;
			head.data = one;
			head.direction = d;
			temp = new lian();
			temp.next = head;
			head = temp;
		}
		// 初始化数据
		l = originleft + 1;
		t = origintop;
		d = 2;
		if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
			map[l][t] = true;
			one = new lu();
			one.x = l;
			one.y = t;
			head.data = one;
			head.direction = d;
			temp = new lian();
			temp.next = head;
			head = temp;
		}
		// 初始化数据
		l = originleft;
		t = origintop - 1;
		d = 3;
		if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
			map[l][t] = true;
			one = new lu();
			one.x = l;
			one.y = t;
			head.data = one;
			head.direction = d;
			temp = new lian();
			temp.next = head;
			head = temp;
		}
		// 初始化数据
		l = originleft;
		t = origintop + 1;
		d = 4;
		if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
			map[l][t] = true;
			one = new lu();
			one.x = l;
			one.y = t;
			head.data = one;
			head.direction = d;
			temp = new lian();
			temp.next = head;
			head = temp;
		}
		temp = head;
		htwo = new lian();
		do {
			while (temp.next != null) {
				lu te;
				te = temp.data;
				if (temp.direction == 1) {
					// 新建数据
					l = te.x - 1;
					t = te.y;
					d = 1;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
					// 新建数据
					l = te.x;
					t = te.y - 1;
					d = 3;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
					// 新建数据
					l = te.x;
					t = te.y + 1;
					d = 4;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
				} else if (temp.direction == 2) {
					// 新建数据
					l = te.x + 1;
					t = te.y;
					d = 2;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
					// 新建数据
					l = te.x;
					t = te.y + 1;
					d = 4;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
					// 新建数据
					l = te.x;
					t = te.y - 1;
					d = 3;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
				} else if (temp.direction == 3) {
					// 新建数据
					l = te.x;
					t = te.y - 1;
					d = 3;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
					// 新建数据
					l = te.x + 1;
					t = te.y;
					d = 2;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
					// 新建数据
					l = te.x - 1;
					t = te.y;
					d = 1;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
				} else if (temp.direction == 4) {
					// 新建数据
					l = te.x;
					t = te.y + 1;
					d = 4;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
					// 新建数据
					l = te.x - 1;
					t = te.y;
					d = 1;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
					// 新建数据
					l = te.x + 1;
					t = te.y;
					d = 2;
					if (l >= 0 && t >= 0 && l < mapwidth && t < mapheight && map[l][t] == false) {
						if (l == left && t == top) {
							return;
						}
						map[l][t] = true;
						one = new lu();
						one.x = l;
						one.y = t;
						one.previous = te;
						htwo.data = one;
						htwo.direction = d;
						lian tem = new lian();
						tem.next = htwo;
						htwo = tem;
					}
				}
				temp = temp.next;
			}
			temp = htwo;
			htwo = new lian();
		} while (temp.next != null);
	}
}
