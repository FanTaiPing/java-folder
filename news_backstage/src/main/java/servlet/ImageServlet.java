package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		int width=100;
		int height=40;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();

		graphic.setColor(Color.getColor("#d1a0e3"));
		graphic.fillRect(0, 0, width, height);

		Color[] colors = new Color[] { Color.black, Color.GRAY, Color.yellow, Color.RED, Color.BLACK, Color.ORANGE,
				Color.CYAN };
		// 在 "画板"上生成干扰线条 ( 50 是线条个数)
		for (int i = 0; i < 50; i++) {
			graphic.setColor(colors[random.nextInt(colors.length)]);
			final int x = random.nextInt(width);
			final int y = random.nextInt(height);
			final int w = random.nextInt(20);
			final int h = random.nextInt(20);
			final int signA = random.nextBoolean() ? 1 : -1;
			final int signB = random.nextBoolean() ? 1 : -1;
			graphic.drawLine(x, y, x + w * signA, y + h * signB);
		}

		// 在 "画板"上绘制字母
		graphic.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		for (int i = 0; i < 4; i++) {
			final int temp = random.nextInt(26) + 97;
			String s = String.valueOf((char) temp);
			sb.append(s);
			graphic.setColor(colors[random.nextInt(colors.length)]);
			graphic.drawString(s, i * (width / 4), height - (height / 3));
		}
		graphic.dispose();
		try {
			ImageIO.write(image, "jpeg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		HttpSession session = request.getSession();
		String rand=sb.toString();
		session.setAttribute("rand", rand);
	}
}
