package mobile.hall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import io.utils.PathUtils;

/**
 * 话卡使用 类
 * 
 * @author y
 *
 */
public class CardUtil {
	Scanner input = new Scanner(System.in);
	// 已注册的嗖嗖移动用户列表
	static Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
	// 所有卡号的消费记录列表
	static Map<String, List<ConsumInfo>> infos = new HashMap<String, List<ConsumInfo>>();
	// 使用场景列表
	static Map<Integer, Scene> scenes = new HashMap<Integer, Scene>();

	Scene scene0 = new Scene("通话", 90, "问候客户，谁知其如此难缠，通话90分钟", 20);
	Scene scene1 = new Scene("发短信", 50, "通知朋友手机换号，发送短信50条", 30);
	Scene scene2 = new Scene("发短信", 5, "参与环境保护实施方案问卷调查，发送短信5条", 35);
	Scene scene3 = new Scene("上网", 2048, "刷视频使用流量2G", 40);
	Scene scene4 = new Scene("上网", 500, "和朋友打游戏，使用流量500MB", 45);

	/**
	 * 初始化用户场景方法
	 */
	public void initScene() {
		// 创建三个用户对象并对其赋值 手机卡号 ——>用户名 ——>密码 ——>套餐类型
		// ——>消费金额——>当前余额——>实际月通话时间——>实际月短信条数——>实际月流量
		MobileCard root1 = new MobileCard("13912345678", "阿呆", "123456", new SuperPackage(), 50, 150, 15, 500);
		MobileCard root2 = new MobileCard("13987931512", "阿衰", "654321", new NetPackage(), 40, 150, 25, 600);
		MobileCard root3 = new MobileCard("13987931513", "阿帅", "111222", new TalkPackage(), 30, 150, 35, 700);

		// 将移动卡信息添加到嗖嗖移动用户列表集合里
		CardUtil.cards.put("13912345678", root1);
		CardUtil.cards.put("13987931512", root2);
		CardUtil.cards.put("13987931513", root3);

		// 创建一个消费记录对象并给其赋值 手机号码 ——>通话时间 ——>消费类型 ——>消费数据（流量/短信）
		ConsumInfo info = new ConsumInfo("13912345678", "上网", 2048);

		// 创建一个list集合
		List<ConsumInfo> list = new ArrayList<ConsumInfo>();
		// 将一条消费记录添加到list集合里面
		list.add(info);
		// 将list集合里面的记录添加到map集合里面
		infos.put(info.cardNumber, list);
	}

	/**
	 * 是否存在此用户
	 * 
	 * @param number
	 * @param passWard
	 * @return
	 */
	public boolean isExistCard(String number, String passWard) {
		if (cards.containsKey(number) && (cards.get(number)).getPassWard().equals(passWard)) {
			return true;
		}
		System.out.println("登录失败！此用户不存在！");
		return false;
	}

	/**
	 * 查找指定卡号是否已注册
	 * 
	 * @param searchNumber
	 * @return
	 */
	public boolean isExistCard(String searchNumber) {
		// 使用Itereator迭代器迭代
		Set keyMap = cards.keySet();
		Iterator it = keyMap.iterator();

		// hasNext()是否包含下一条元素
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.equals(searchNumber)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 创建卡号
	 * 
	 * @return
	 */
	public String createNumber() {
		// 固定号码前三位139，则剩下8位需要随机生成，范围在10000000--100000000之间
		Random random = new Random();
		boolean isExit = false;
		String number = "";
		int temp = 0;
		do {
			isExit = false;
			while (temp < 10000000) {
				temp = random.nextInt(100000000);
			}
			number = "139" + temp;
			if (cards != null) {
				// 使用Itereator迭代器迭代
				Set keyMap = cards.keySet();
				Iterator it = keyMap.iterator();

				// hasNext()是否包含下一条元素
				while (it.hasNext()) {
					String key = (String) it.next();
					if (key.equals(number)) {
						isExit = true;
						break;
					}
				}
			}
		} while (isExit);
		return number;
	}

	/**
	 * 生成指定个数的新卡号列表
	 * 
	 * @param count
	 * @return
	 */
	public String[] getNewNumbers(int count) {
		String[] strs = new String[count];
		for (int i = 0; i < count; i++) {
			// 将随机生成的卡号存入strs[i]数组中
			strs[i] = createNumber();
		}
		return strs;
	}

	/**
	 * 添加新卡
	 * 
	 * @param card
	 */
	public void addCard(MobileCard card) {
		// 将新卡的信息添加到cards集合中
		cards.put(card.getCardNumber(), card);

		ConsumInfo info = new ConsumInfo(card.getCardNumber(), "套餐费用", card.getSetPackage().getPrice());
		// 创建一个list集合
		List<ConsumInfo> list = new ArrayList<ConsumInfo>();
		// 将一条消费记录添加到list集合里面
		list.add(info);
		// 将list集合里面的记录添加到map集合里面
		infos.put(info.cardNumber, list);
	}

	/**
	 * 删除卡号
	 * 
	 * @param delNumber
	 */
	public void delCard(String delNumber) {
		// 找到对应得键
		if (cards.containsKey(delNumber)) {
			// 移除键对应的值 手机号
			cards.remove(delNumber);
			System.out.println("卡号：" + delNumber + "办理退网成功！");
			System.out.println("欢迎下次使用！");
		} else {
			System.out.println("手机号输入错误，办理退网失败！");
		}
	}

	/**
	 * 本月账单查询
	 * 
	 * @param number
	 */
	public void showAmountDetail(String number) {
		StringBuffer meg = new StringBuffer();
		MobileCard card = cards.get(number); // 要查询的卡
		meg.append("您的卡号:" + card.getCardNumber() + "当月账单为:\n");
		meg.append("套餐资费:" + card.getSetPackage().getPrice() + "元\n");
		// 套餐固定资费和超出套餐使用费用总和
		meg.append("合计(消费金额):" + card.getConsumAmount() + "元\n");
		meg.append("账户余额:" + card.getMoney() + "元");
		// 显示本月消费详细信息
		System.out.println(meg);
		card.getSetPackage().showInfo();
	}

	/**
	 * 查询指定卡号套餐余量
	 * 
	 * @param searchNumber
	 */
	public void showRemainDetail(String searchNumber) {
		MobileCard card = cards.get(searchNumber);
		StringBuffer mesg = new StringBuffer();
		mesg.append("你的卡号是：" + searchNumber + "\n套餐内：\n");
		ServicePackage pack = card.getSetPackage();
		if (pack instanceof TalkPackage) {
			// 父类转子类，向下转型，强制转换
			TalkPackage cardPack = (TalkPackage) pack;
			// 剩余的通话时间 使用三元运算符 固定通话时间 > 实际通话时间 剩余通话时间 = 固定通话时间 - 实际通话时间 ，反之剩余通话时间为0
			int suplusTalkTime = cardPack.talkTime > card.getRealTalkTime()
					? (cardPack.talkTime - card.getRealTalkTime())
					: 0;
			mesg.append("剩余通话时长为：" + suplusTalkTime + "分钟\n");
			int suplusSMSCount = cardPack.smsCount > card.getRealSMSCount()
					? (cardPack.smsCount - card.getRealSMSCount())
					: 0;
			mesg.append("剩余短信条数为：" + suplusSMSCount + "\n");

		} else if (pack instanceof SuperPackage) {
			SuperPackage cardPack = (SuperPackage) pack;
			int suplusTalkTime = cardPack.talkTime > card.getRealTalkTime()
					? (cardPack.talkTime - card.getRealTalkTime())
					: 0;
			mesg.append("剩余通话时长为：" + suplusTalkTime + "分钟\n");
			int suplusSMSCount = cardPack.smsCount > card.getRealSMSCount()
					? (cardPack.smsCount - card.getRealSMSCount())
					: 0;
			mesg.append("剩余短信条数为：" + suplusSMSCount + "\n");
			int suplusFlow = cardPack.flow > card.getRealFlow() ? (cardPack.flow - card.getRealFlow()) : 0;
			mesg.append("剩余流量为：" + suplusFlow + "MB\n");
		} else if (pack instanceof NetPackage) {
			NetPackage cardPack = (NetPackage) pack;
			int suplusFlow = cardPack.flow > card.getRealFlow() ? (cardPack.flow - card.getRealFlow()) : 0;
			mesg.append("剩余流量为：" + suplusFlow + "MB\n");
		}
		System.out.println(mesg);
	}

	/**
	 * 查询指定卡当月消费详单*************************************************
	 * 
	 * @param searchNumber
	 */
	public void showConsumInfoDetail(String searchNumber) throws Exception {
		Writer fileWriter = null;
		try {
			fileWriter = new FileWriter(PathUtils.nameOutPath);
			Set<String> cardNumbers = infos.keySet();
			Iterator<String> it = cardNumbers.iterator();
			List<ConsumInfo> list = new ArrayList<ConsumInfo>();

			// 现有消费列表中是否存在此卡的消费记录
			boolean isExist = false;
			while (it.hasNext()) {
				String numberKey = it.next();
				if (searchNumber.equals(numberKey)) {
					// 存储指定卡的所有消费记录
					list = infos.get(searchNumber);
					isExist = true;
					break;
				}
			}
			if (isExist = true) {

				StringBuffer contents = new StringBuffer("************" + searchNumber + "的消费记录\n");
				contents.append("序号\t卡号\t\t\t类型\t\t数据（通话（分钟）/上网（MB）/短信（条））\n");
				for (int i = 0; i < list.size(); i++) {
					ConsumInfo info = list.get(i);
//					System.out.println((i + 1) + "\t" + info.cardNumber + "\t\t" + info.type + "\t\t" + info.consumData + "\n");
					contents.append(
							(i + 1) + "\t" + info.cardNumber + "\t\t" + info.type + "\t\t" + info.consumData + "\n");
				}
				fileWriter.write(contents.toString());
				fileWriter.flush();
				System.out.println("消息记录打印完成！\n");
			} else {
				System.out.println("不存在此号码的消费记录，无法打印！\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileWriter.close();
		}
	}

	/**
	 * 指定卡号换套餐
	 * 
	 * @param number
	 * @param packNum
	 */
	public void changingPack(String number) {
		System.out.println("1.话痨套餐 2.网虫套餐 3.超人套餐 ：请选则套餐序号：");
		int num = input.nextInt();
		switch (num) {
		case 1:
			if (cards.get(number).getSetPackage() instanceof TalkPackage) {
				System.out.println("对不起，您已经是该套餐用户，无需更换套餐！");
				// 如果账户余额小于月资费，则不可以更改套餐
			} else if (cards.get(number).getMoney() < cards.get(number).getSetPackage().getPrice()) {
				System.out.println("对不起，您的余额不足以支付新的本月套餐资费，无法更换套餐，请充值后再更换！");
			} else {
				cards.get(number).setRealTalkTime(0);
				cards.get(number).setRealSMSCount(0);
				cards.get(number).setRealFlow(0);
				cards.get(number).setSetPackage(createPack(num));
				System.out.println("恭喜你，套餐更换成功！");
				// 显示每月的固定套餐信息
				createPack(num).showInfo();
			}
			break;
		case 2:
			if (cards.get(number).getSetPackage() instanceof NetPackage) {
				System.out.println("对不起，您已经是该套餐用户，无需更换套餐！");
			} else if (cards.get(number).getMoney() < cards.get(number).getSetPackage().getPrice()) {
				System.out.println("对不起，您的余额不足以支付新的本月套餐资费，无法更换套餐，请充值后再更换！");
			} else {
				cards.get(number).setRealTalkTime(0);
				cards.get(number).setRealSMSCount(0);
				cards.get(number).setRealFlow(0);
				cards.get(number).setSetPackage(createPack(num));
				System.out.println("恭喜你，套餐更换成功！");
				// 显示每月的固定套餐信息
				createPack(num).showInfo();
			}
			break;
		case 3:
			if (cards.get(number).getSetPackage() instanceof SuperPackage) {
				System.out.println("对不起，您已经是该套餐用户，无需更换套餐！");
			} else if (cards.get(number).getMoney() < cards.get(number).getSetPackage().getPrice()) {
				System.out.println("对不起，您的余额不足以支付新的本月套餐资费，无法更换套餐，请充值后再更换！");
			} else {
				cards.get(number).setRealTalkTime(0);
				cards.get(number).setRealSMSCount(0);
				cards.get(number).setRealFlow(0);
				cards.get(number).setSetPackage(createPack(num));
				System.out.println("恭喜你，套餐更换成功！");
				// 显示每月的固定套餐信息
				createPack(num).showInfo();
			}
			break;
		}
	}

	/**
	 * 为指定手机卡充值*********************************************
	 * 
	 * @param number
	 * @param money
	 */
	public void changMoney(String number, double money) {
		cards.get(number).setMoney(cards.get(number).getMoney() + money);
		System.out.println("充值成功！充值后你的" + number + "账户余额为" + cards.get(number).getMoney());
	}

	/**
	 * 添加一条指定卡的消费记录
	 * 
	 * @param number
	 * @param info
	 */
	public void addConsumInfo(String number, ConsumInfo info) {
		// 判断infos对象的集合里是否存在此卡号，如果存在则添加一条新的消费记录
		if (infos.containsKey(number)) {
			infos.get(number).add(info);
			// 如果不存在，则给该卡的消费信息集合添加一条新的消费纪录
		} else {
			List<ConsumInfo> list = new ArrayList<ConsumInfo>();
			list.add(info);
			infos.put(number, list);
		}
	}

	/**
	 * 使用嗖嗖
	 * 
	 * @param number
	 */
	public void userSoso(String number) {
//添加初始场景Map集合的键值对
		scenes.put(0, scene0);
		scenes.put(1, scene1);
		scenes.put(2, scene2);
		scenes.put(3, scene3);
		scenes.put(4, scene4);
		// 获取卡的对象
		MobileCard card = cards.get(number);
		// 获取卡的套餐属性
		ServicePackage pack = card.getSetPackage();
		int num = 0;
		int temp = 0;
		while (true) {
			// 进入随机场景
			num = new Random().nextInt(6);
			// 获取进入随机场景所对应的序号
			Scene scene = scenes.get(num);
			switch (num) {
			// 0 打电话场景
			case 0:
				// 判断该卡所属套餐是否支持通话功能
				if (pack instanceof CallService) {
					// 执行通话方法
					System.out.println(scene.description);
					CallService callService = (CallService) pack;
					try {
						temp = callService.call(scene.data, card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// 添加一条消费记录
					addConsumInfo(number, new ConsumInfo(number, scene.type, temp));
					break;
				} else {
					// 如果该卡套餐不支持通话功能，则重新生成随机数选择其他场景
					continue;
				}

				// 1、2发短信场景
			case 1:
			case 2:
				// 判断卡所属套餐是否支持短信功能
				if (pack instanceof SendService) {
					// 执行发短信方法
					System.out.println(scene.description);
					SendService sendService = (SendService) pack;
					try {
						temp = sendService.sendMessage(scene.data, card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// 添加一条消费记录
					addConsumInfo(number, new ConsumInfo(number, scene.type, temp));
					break;
				} else {
					continue;
				}

				// 3、4上网场景
			case 3:
			case 4:
				// 判断卡所属套餐是否支持上网功能
				if (pack instanceof NetService) {
					// 执行发短信方法
					System.out.println(scene.description);
					NetService netService = (NetService) pack;
					try {
						temp = netService.netPlay(scene.data, card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// 添加一条消费记录
					addConsumInfo(number, new ConsumInfo(number, scene.type, temp));
					break;
				} else {
					continue;
				}
			}
			break;
		}
	}

	/**
	 * 根据套餐序号返回套餐对象
	 * 
	 * @param packId
	 * @return
	 */
	public ServicePackage createPack(int packId) {
		ServicePackage servicePackage = null;
		switch (packId) {
		case 1:
			// 选择1，表示话痨套餐
			servicePackage = new TalkPackage();
			break;
		case 2:
			// 选择2，表示网虫套餐
			servicePackage = new NetPackage();
			break;
		case 3:
			// 选择3，表示超人套餐
			servicePackage = new SuperPackage();
			break;
		default:

			break;
		}
		// 返回套餐类型
		return servicePackage;
	}

	/**
	 * 显示资费说明
	 * 
	 * @throws IOException
	 */
	public void showDescription() throws Exception {
		FileReader re = null;
		BufferedReader br = null;
		try {
			// 创建一个FileReader对象获取文件路径
			re = new FileReader(PathUtils.namePath);
			// 创建一个BufferedReader对象读取文本文件
			br = new BufferedReader(re);
			// 读取一行数据
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (re != null) {
				re.close();
			}
			if (br != null) {
				br.close();
			}
		}
	}

	/**
	 * 功能菜单开始位置
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception {
		initScene(); // 调用初始化方法
		boolean isEsc = true; // 循环操作
		do {
			System.out.println("*******************欢迎使用嗖嗖移动业务大厅*******************");
			System.out.println("1.用户登录  2.用户注册  3.使用嗖嗖  4.话费充值  5.资费说明  6.退出系统");
			System.out.print("请选择：");
			int key = 1;
			try {
				key = input.nextInt();
			} catch (Exception e) {
				System.out.println("输入有误，请重新输入！");
			}
			switch (key) {
			case 1:
				// 用户登录
				System.out.println("**********欢迎使用用户登录功能！***********");
				cardMenu();
				continue;
			case 2:
				// 用户注册
				System.out.println("欢迎使用用户注册功能！");
				registCard();
				continue;
			case 3:
				System.out.println("执行使用嗖嗖功能");
				System.out.println("请输入手机卡号:");
				String number = input.next();
				// 调用使用soso
				userSoso(number);
				continue;
			case 4:
				// 调用话费充值
				System.out.println("请输入手机卡号:");
				number = input.next();
				System.out.println("请输入你要充值的金额:");
				double money = input.nextInt();
				changMoney(number, money);
				continue;
			case 5:
				// 资费说明查询
				showDescription();
				continue;
			case 6:
				System.out.println("谢谢使用！");
				System.exit(0);
				break;
			default:
				System.out.println("输入有误，请重新输入！");
				continue;
			}
		} while (isEsc); // 判断是否循环
	}

	/**
	 * 用户登录进入二级菜单
	 * 
	 * @throws Exception
	 */
	private void cardMenu() throws Exception {
		System.out.println("请输入手机卡号：");
		String cardNumber = input.next();
		System.out.println("请输入密码：");
		String passWard = input.next();
		if (isExistCard(cardNumber, passWard)) {
			System.out.println("登录成功");
		} else {
			return;
		}
		boolean isEsc = true; // 循环操作
		do {
			System.out.println("******嗖嗖移动用户菜单******");
			System.out.println("1.本月账单查询");
			System.out.println("2.套餐余量查询");
			System.out.println("3.打印消费详单");
			System.out.println("4.套餐变更");
			System.out.println("5.办理退网");
			System.out.print("请选择(输入1~5选择功能,其他键返回上一级)：");
			int key = 1;
			try {
				key = input.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}
			switch (key) {
			case 1:
				// 调用本月账单查询
				showAmountDetail(cardNumber);
				continue;
			case 2:
				// 调用套餐余量查询
				showRemainDetail(cardNumber);
				continue;
			case 3:
				// 调用打印消费详单
				showConsumInfoDetail(cardNumber);
				continue;
			case 4:
				// 给指定卡更换套餐
				changingPack(cardNumber);
				continue;
			case 5:
				// 办理退网
				delCard(cardNumber);
				isEsc = false;
				break;
			default:
				isEsc = false;
			}
			// 判断是否循环
		} while (isEsc);
	}

	/**
	 * 用户注册功能
	 */
	private void registCard() {
//		// 实例化嗖嗖移动卡类
		MobileCard mobileCard = new MobileCard();
		ServicePackage service = null;
		System.out.println("************可选择的卡号************");
		// 通过超级循环遍历输出卡号
		String[] cardNumbers = getNewNumbers(9);
		for (int i = 0; i < cardNumbers.length; i++) {
			System.out.print((i + 1) + ":" + cardNumbers[i] + "\t");
			if (2 == i || 5 == i || 8 == i) {
				System.out.println();
			}
		}
		System.out.println("请选择卡号(输入1~9的序号)：");
		int key = input.nextInt();

		if (key >= 1 && key <= 9) {

			mobileCard.setCardNumber(cardNumbers[key - 1]);
			System.out.println("1.话唠套餐  2.网虫套餐  3.超人套餐 ， 请选择套餐（输入序号）:");
		} else {
			System.out.print("输入错误！请输入（1~9）的整数:");
		}

		boolean bol = true;

		int packageNum = input.nextInt();
		while (bol) {
			if (packageNum <= 3 && packageNum >= 1) {
				service = createPack(packageNum);
				mobileCard.setSetPackage(service); //
				bol = false;
			} else {
				System.out.println("输入错误，请重新选择：");
				packageNum = input.nextInt();
			}
		}

		System.out.println("请输入姓名：");
		String userName = input.next();
		System.out.println("请输入密码：");
		String passWord = input.next();
		System.out.println("请输入预存话费：");
		double money = input.nextInt();
		mobileCard.setUserName(userName);
		mobileCard.setPassWard(passWord);
		mobileCard.setMoney(money);
		while (money < service.getPrice()) {
			System.out.println("您预存话费金额不足以支付本月固定套餐资费，请重新充值：");
			money = input.nextInt();
		}
		// 当前输入的余额减去月租
		mobileCard.setMoney(money - service.getPrice());
		// 注册新用户添加到集合
		mobileCard.setConsumAmount(service.getPrice());
		addCard(mobileCard);
		mobileCard.showMsg();
	}
}
