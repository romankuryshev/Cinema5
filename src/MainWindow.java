
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainWindow extends JFrame {
    List<String> bannerList = Arrays.asList("banner2.png", "banner3.png", "banner4.png", "banner1.png");
    int counter = 0;
    boolean t = false;
    JPanel panel = new JPanel();
    JButton btn1 = new JButton(">");
    JButton btn2 = new JButton("<");
    JButton btnToday = new JButton("Сегодня");
    JButton btnSoon = new JButton("Скоро");
    JButton btnCard = new JButton("Пушкинская карта");
    String[] cities = {"Казань", "Москва", "Санкт-Петербург", "Набережные Челны", "Красноярск", "Новосибирск", "Йошкар-Ола"};
    JComboBox<String> city = new JComboBox<String>(cities);
    JPanel film1;
    JPanel film2;
    JPanel film3;
    JButton infoFilm1;
    JButton infoFilm2;
    JButton infoFilm3;
    JButton infoFilm4;
    JButton infoFilm5;
    JButton infoFilm6;
    Img img;
    Img img2;

    MainWindow() {
        super();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension scrSize = kit.getScreenSize();
        setBounds(scrSize.width / 2 - 700, scrSize.height / 2 - 450, 1400, 900);

        addButtons();
        addPosters();

        btnToday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPosters();
                add(img);
                revalidate();
            }
        });

        btnSoon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPostersSoon();
                add(img);
                revalidate();
            }
        });

        btnCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardWindow card = new CardWindow();
                card.setVisible(true);
            }
        });

        img = new Img(bannerList.get(counter++));
        add(img);

        btn1.addActionListener(new BannerChanger(true));
        btn2.addActionListener(new BannerChanger(false));
    }

    public void addButtons() {
        btn1.setFont(new Font("lato", Font.PLAIN, 50));
        //btn1.setBounds(1300, 225, 100, 30);
        btn1.setBounds(1300, 60, 100, 350);
        btn1.setBorderPainted(false);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1.setFocusPainted(false);
        btn1.setForeground(Color.white);

        btn2.setFont(new Font("lato", Font.PLAIN, 50));
        //btn2.setBounds(0, 225, 100, 30);
        btn2.setBounds(0, 60, 100, 350);
        btn2.setBorderPainted(false);
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2.setFocusPainted(false);
        btn2.setForeground(Color.white);

        add(btn1);
        add(btn2);

        btnCard.setFont(new Font("lato", Font.PLAIN, 20));
        btnToday.setFont(new Font("lato", Font.PLAIN, 20));
        btnSoon.setFont(new Font("lato", Font.PLAIN, 20));
        city.setFont(new Font("lato", Font.PLAIN, 20));

        btnCard.setBorderPainted(false);
        btnToday.setBorderPainted(false);
        btnSoon.setBorderPainted(false);

        btnCard.setFocusPainted(false);
        btnToday.setFocusPainted(false);
        btnSoon.setFocusPainted(false);

        btnCard.addMouseListener(new topBarListener(btnCard));
        btnSoon.addMouseListener(new topBarListener(btnSoon));
        btnToday.addMouseListener(new topBarListener(btnToday));

        btnCard.setForeground(new Color(138, 138, 142));
        btnSoon.setForeground(new Color(138, 138, 142));
        btnToday.setForeground(new Color(138, 138, 142));
        city.setForeground(new Color(138, 138, 142));

        panel.add(btnToday);
        panel.add(btnSoon);
        panel.add(btnCard);
        panel.setBounds(600, 10, 800, 50);
        panel.add(city);
        add(panel);
    }

    public void addPosters() {
        if (film1 != null) {
            film1.removeAll();
            film2.removeAll();
            film3.removeAll();
            revalidate();
            repaint();
        }
        else {
            film1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            film2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            film3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }

        film1.setBounds(10, 420, 452, 340);
        film1.setBackground(new Color(248, 248, 250));
        Image poster1;
        try {
            poster1 = ImageIO.read(new File("poster1.jpeg")).getScaledInstance(215, 330, Image.SCALE_FAST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel p1l = new JLabel(new ImageIcon(poster1));
        JPanel film1Text = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel film1Name = new JLabel("<HTML><p>Мира: космос<p> не расстояние");
        film1Name.setBounds(510, 100, 200, 200);
        JLabel film1Type = new JLabel("<HTML> <p> Приключения <p> боевик");
        film1Name.setFont(new Font("lato", Font.PLAIN, 26));
        film1Name.setBackground(new Color(248, 248, 250));
        film1Text.setBackground(new Color(248, 248, 250));
        film1Type.setFont(new Font("lato", Font.PLAIN, 20));
        film1Type.setForeground(new Color(138, 138, 142));

        film1.add(p1l);
        film1.add(film1Text);
        film1Text.add(film1Name);
        film1Text.add(film1Type);

        infoFilm1 = new JButton("Информация о фильме");
        infoFilm1.setFont(new Font("lato", Font.PLAIN, 15));
        infoFilm1.setFocusPainted(false);
        infoFilm1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        film1Text.add(infoFilm1);



        film2.setBounds(472, 420, 452, 340);
        film2.setBackground(new Color(248, 248, 250));
        Image poster2;
        try {
            poster2 = ImageIO.read(new File("poster2.png")).getScaledInstance(215, 330, Image.SCALE_FAST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel p2l = new JLabel(new ImageIcon(poster2));
        JPanel film2Text = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel film2Name = new JLabel("<HTML><p>Пётр I: <p>Последний царь");
        JLabel film2Type = new JLabel("<HTML> <p>Исторический, драма");
        film2Name.setFont(new Font("lato", Font.PLAIN, 26));
        film2Name.setBackground(new Color(248, 248, 250));
        film2Text.setBackground(new Color(248, 248, 250));
        film2Type.setFont(new Font("lato", Font.PLAIN, 20));
        film2Type.setForeground(new Color(138, 138, 142));
        film2Text.add(film2Name);
        film2Text.add(film2Type);

        infoFilm2 = new JButton("Информация о фильме");
        infoFilm2.setFont(new Font("lato", Font.PLAIN, 15));
        infoFilm2.setFocusPainted(false);
        infoFilm2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        film2Text.add(infoFilm2);
        film2.add(p2l);
        film2.add(film2Text);


        film3.setBounds(934, 420, 452, 340);
        film3.setBackground(new Color(248, 248, 250));
        Image poster3;
        try {
            poster3 = ImageIO.read(new File("poster3.png")).getScaledInstance(215, 330, Image.SCALE_FAST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel p3l = new JLabel(new ImageIcon(poster3));
        film3.add(p3l);
        JPanel film3Text = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel film3Name = new JLabel("<HTML><p>Приключения <p>Тедди");
        JLabel film3Type = new JLabel("<HTML>Семейный");
        film3Name.setFont(new Font("lato", Font.PLAIN, 26));
        film3Name.setBackground(new Color(248, 248, 250));
        film3Text.setBackground(new Color(248, 248, 250));
        film3Type.setFont(new Font("lato", Font.PLAIN, 20));
        film3Type.setForeground(new Color(138, 138, 142));
        film3Text.add(film3Name);
        film3Text.add(film3Type);

        infoFilm3 = new JButton("Информация о фильме");
        infoFilm3.setFont(new Font("lato", Font.PLAIN, 15));
        infoFilm3.setFocusPainted(false);
        infoFilm3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        film3Text.add(infoFilm3);
        film3.add(film3Text);


        infoFilm1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showInfoFilm(new Film("Film1.png"));
            }
        });
        infoFilm2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showInfoFilm(new Film("Film2.png"));
            }
        });
        infoFilm3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showInfoFilm(new Film("Film3.png"));
            }
        });
        revalidate();
        repaint();
        add(film1);
        add(film2);
        add(film3);
    }

    public void addPostersSoon() {
        if (film1 != null) {
            film1.removeAll();
            film2.removeAll();
            film3.removeAll();
            revalidate();
            repaint();
        }
        else {
            film1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            film2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            film3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }

        film1.setBounds(10, 420, 452, 340);
        film1.setBackground(new Color(248, 248, 250));
        Image poster4;
        try {
            poster4 = ImageIO.read(new File("poster4.png")).getScaledInstance(215, 330, Image.SCALE_FAST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel p4l = new JLabel(new ImageIcon(poster4));
        JPanel film4Text = new JPanel(new GridLayout(4, 1, 10, 10));
        JLabel film4Soon = new JLabel("<HTML><p>Скоро в <p>прокате!");
        film4Soon.setFont(new Font("lato", Font.PLAIN, 20));
        film4Soon.setForeground(new Color(156, 56, 221));
        JLabel film4Name = new JLabel("<HTML><p>Девятаев: <p>история героя");
        JLabel film4Type = new JLabel("Исторический");
        film4Name.setFont(new Font("lato", Font.PLAIN, 26));
        film4Name.setBackground(new Color(248, 248, 250));
        film4Text.setBackground(new Color(248, 248, 250));
        film4Type.setFont(new Font("lato", Font.PLAIN, 20));
        film4Type.setForeground(new Color(138, 138, 142));

        film1.add(p4l);
        film1.add(film4Text);
        film4Text.add(film4Soon);
        film4Text.add(film4Name);
        film4Text.add(film4Type);

        infoFilm4 = new JButton("Информация о фильме");
        infoFilm4.setFont(new Font("lato", Font.PLAIN, 15));
        infoFilm4.setFocusPainted(false);
        infoFilm4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        film4Text.add(infoFilm4);


        film2.setBounds(472, 420, 452, 340);
        film2.setBackground(new Color(248, 248, 250));
        Image poster5;
        try {
            poster5 = ImageIO.read(new File("poster5.jpg")).getScaledInstance(215, 330, Image.SCALE_FAST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel p5l = new JLabel(new ImageIcon(poster5));
        JPanel film5Text = new JPanel(new GridLayout(4, 1, 10, 10));
        JLabel film5Name = new JLabel("<HTML><p><p>На ощупь");
        JLabel film5Type = new JLabel("<HTML><p>Триллер, <p>экшн");
        film5Name.setFont(new Font("lato", Font.PLAIN, 26));
        film5Name.setBackground(new Color(248, 248, 250));
        film5Text.setBackground(new Color(248, 248, 250));
        film5Type.setFont(new Font("lato", Font.PLAIN, 20));
        film5Type.setForeground(new Color(138, 138, 142));
        JLabel film5Soon = new JLabel("<HTML><p>Скоро в <p>прокате!");
        film5Soon.setFont(new Font("lato", Font.PLAIN, 20));
        film5Soon.setForeground(new Color(156, 56, 221));
        film5Text.add(film5Soon);
        film5Text.add(film5Name);
        film5Text.add(film5Type);

        infoFilm5 = new JButton("Информация о фильме");
        infoFilm5.setFont(new Font("lato", Font.PLAIN, 15));
        infoFilm5.setFocusPainted(false);
        infoFilm5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        film5Text.add(infoFilm5);
        film2.add(p5l);
        film2.add(film5Text);


        film3.setBounds(934, 420, 452, 340);
        film3.setBackground(new Color(248, 248, 250));
        Image poster6;
        try {
            poster6 = ImageIO.read(new File("poster6.jpg")).getScaledInstance(215, 330, Image.SCALE_FAST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel p6l = new JLabel(new ImageIcon(poster6));
        film3.add(p6l);
        JPanel film6Text = new JPanel(new GridLayout(4, 1, 10, 10));
        JLabel film6Name = new JLabel("<HTML><p>Тайный <p>Санта");
        JLabel film6Type = new JLabel("Комедия");
        film6Name.setFont(new Font("lato", Font.PLAIN, 26));
        film6Name.setBackground(new Color(248, 248, 250));
        film6Text.setBackground(new Color(248, 248, 250));
        film6Type.setFont(new Font("lato", Font.PLAIN, 20));
        film6Type.setForeground(new Color(138, 138, 142));
        JLabel film6Soon = new JLabel("<HTML><p>Скоро в <p>прокате!");
        film6Soon.setFont(new Font("lato", Font.PLAIN, 20));
        film6Soon.setForeground(new Color(156, 56, 221));
        film6Text.add(film6Soon);
        film6Text.add(film6Name);
        film6Text.add(film6Type);

        infoFilm6 = new JButton("Информация о фильме");
        infoFilm6.setFont(new Font("lato", Font.PLAIN, 15));
        infoFilm6.setFocusPainted(false);
        infoFilm6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        film6Text.add(infoFilm6);
        film3.add(film6Text);


        infoFilm4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showInfoFilm(new Film("Film4.png"));
            }
        });
        infoFilm5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showInfoFilm(new Film("Film5.png"));
            }
        });
        infoFilm6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showInfoFilm(new Film("Film6.png"));
            }
        });
        revalidate();
        repaint();
        add(film1);
        add(film2);
        add(film3);
    }

    public class BannerChanger implements ActionListener {
        private boolean direction;

        BannerChanger(boolean direction) {
            this.direction = direction;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (direction) counter++;
            else counter--;

            if (counter >= bannerList.size()) counter = 0;
            else if (counter <= -1) counter = bannerList.size() - 1;
            if (!t) {
                img.setVisible(false);
                img2 = new Img(bannerList.get(counter));
                img2.setVisible(true);
                add(img2);
                t = true;
            } else {
                img2.setVisible(false);
                img = new Img(bannerList.get(counter));
                img.setVisible(true);
                add(img);
                t = false;
            }
        }
    }

    private void changeColor(JButton button, Color clr) {
        button.setForeground(clr);
    }

    public class topBarListener implements MouseListener {
        private final JButton button;

        public topBarListener(JButton button) {
            super();
            this.button = button;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            changeColor(button, Color.BLACK);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            changeColor(button, new Color(138, 138, 142));
        }
    }

    public static class Img extends JComponent {
        String urlForBanner;

        Img(String newUrl) {
            super();
            this.urlForBanner = newUrl;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            String url_logo = "logo-theme.png";
            String url_banner = urlForBanner;
            Image logo, banner;
            try {
                banner = ImageIO.read(new File(url_banner)).getScaledInstance(1400, 350, Image.SCALE_FAST);
                logo = ImageIO.read(new File(url_logo));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g2.drawImage(logo, 200, 15, null);
            g2.drawImage(banner, 0, 60, null);
        }
    }

    public static class Film extends JComponent {
        String url;
        public Film(String url) {
            this.url = url;
        }
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            String urlImg = url;
            Image i;
            g2.setColor(new Color(248, 248, 250));
            g2.fill(new Rectangle(0, 0, 1200, 800));
            try {
                i = ImageIO.read(new File(urlImg));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g2.drawImage(i, 20, 20, null);
        }
    }

    public static class CardWindow extends JFrame {
        public CardWindow() {
            super();
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension scrSize = kit.getScreenSize();
            setBounds(scrSize.width / 2 - 500, scrSize.height / 2 - 350, 1000, 700);
            JPanel background = new JPanel(new FlowLayout(FlowLayout.LEFT));
            background.setBackground(Color.WHITE);
            JLabel header = new JLabel("Промоакция «Выставка по Пушкинской карте + сертификат в кино в подарок!» в Казани");
            header.setFont(new Font("lato", Font.PLAIN, 21));
            JLabel text = new JLabel("<HTML>" +
                    "<style>\n" +
                    "   li {\n" +
                    "    color: rgb(156, 56, 221);\n" +
                    "   }\n" +
                    "   li span {\n" +
                    "    color: black;\n" +
                    "   }\n" +
                    "   p {\n" +
                    "    color: black;\n" +
                    "   }\n" +
                    "  </style>" +
                    "<p>Купи билет на фотовыставку «Девятаев: история героя» по Пушкинской карте и получи в подарок сертификат в кино, которым ты можешь" +
                    "<p>воспользоваться на любой фильм из репертуара кинотеатра." +

                    "<p><p>Для того, чтобы посетить выставку «Девятаев: история Героя» и получить в подарок сертификат в кино, необходимо купить билет на" +
                    "<p>фотовыставку «Девятаев: история Героя» по Пушкинской карте на сайте кинотеатра, прийти в кинотеатр в день, на который куплен билет" +
                    "<p>на фотовыставку. Посмотреть фотовыставку и получить в подарок сертификат в кино в кассе бара." +

                    "<ul>" +
                    "<li><span>Срок действия по ранее полученным сертификатам «Подарочный билет «Выставка» продлевается до 31.12.2022</span></li>" +

                    "<li><span>Сертификат «Подарочный билет «Выставка» - одноразовый, дает право обмена на 1 (один) билет в кино без ограничений по" +
                    "<p>времени сеанса и категории зала. Выдается только тем  Гостям, которые приобрели билет на фотовыставку «Девятаев: " +
                    "<p>история героя».</span></li>" +

                    "<li><span>Сертификат «Подарочный билет «Выставка» не подлежит обмену на билеты концертных показов (фильмов-концертов), показов" +
                    "<p>театральных постановок (театр HD), прямых трансляций (спортивные матчи и т.п.).</span></li>" +

                    "<li><span>Сертификат «Подарочный билет «Выставка» не подлежит возврату и обмену на денежные средства.</span></li>" +

                    "<li><span>Обмен сертификата «Подарочный билет «Выставка» на билет в кино на конкретный сеанс производится строго в том" +
                    "<p>кинотеатре, в котором был приобретен билет на фотовыставку</span></li>" +

                    "<li><span>Срок действия сертификата «Подарочный билет «Выставка» до 31 декабря 2022 года.</span></li>" +
                    "</ul>" +

                    "<p>Период проведения акции с 17 октября до 31 декабря 2022 года." +

                    "<p><p>Фотовыставка размещена в фойе кинотеатра.");
            text.setFont(new Font("lato", Font.PLAIN, 15));
            Image cardImg;
            try {
                cardImg = ImageIO.read(new File("card.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            JLabel ci = new JLabel(new ImageIcon(cardImg));
            background.add("North", header);
            background.add(text);
            background.add(ci);
            add(background);
        }
    }
}