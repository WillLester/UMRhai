package swing;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

/**
 *
 * @author chensiyu
 * @createDate 2011/8/25
 * 转载请注明出自:www.blogjava.net/chensiyu04
 */
public class IScrollBarDemo extends JFrame {

    private JList list = new JList();
    private JScrollPane scrollPane = new JScrollPane();

    public IScrollBarDemo() {
        init();
    }

    private void init() {
        initData();
        initScrollPane();
        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);
    }

    private void initData() {
        DefaultListModel model = new DefaultListModel();
        model.addElement("12345678901234567890123456789010"
                + "123456700000000056789012345678901234567"
                + "890123456789012345670000000000000000000"
                + "0000000890");
        for (int i = 0; i < 20;) {
            model.addElement(++i);
        }
        list.setModel(model);
    }

    private void initScrollPane() {
        scrollPane.getViewport().setView(list);

        scrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());

        if (scrollPane.getCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER) == null) {
            Component component = new JLabel("") {

                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g;
                    Paint oldPaint = g2.getPaint();
                    Rectangle bounds = getBounds();
                    Paint backgroupRectPaint = new GradientPaint(0, 0, new Color(216, 216, 216),
                            bounds.width, bounds.height, new Color(152, 152, 152));
                    g2.setPaint(backgroupRectPaint);
                    g2.fillRect(0, 0, bounds.width, bounds.height);
                    g2.setPaint(oldPaint);

                }
            };
            scrollPane.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, component);
        }
    }

    public static void main(String[] a) {
        IScrollBarDemo frame = new IScrollBarDemo();
        frame.setTitle("ScrollBar Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }
}

class IScrollBarUI extends BasicScrollBarUI {

    private static final float ARC_NUMBER = 20.0f;

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {

        Graphics2D g2 = (Graphics2D) g;
        int w = thumbBounds.width - 1;
        int h = thumbBounds.height - 1;
        Paint oldPaint = g2.getPaint();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.translate(thumbBounds.x, thumbBounds.y);

        Shape arcRect = new RoundRectangle2D.Float(0.0f, 0.0f, (float) w, (float) h, ARC_NUMBER, ARC_NUMBER);
        //填充滚动条矩形
        Paint arcRectPaint = null;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            arcRectPaint = new GradientPaint(0, 0, new Color(225, 225, 225),
                    thumbBounds.width, 0, new Color(162, 162, 162));
        } else {
            arcRectPaint = new GradientPaint(0, 0, new Color(225, 225, 225),
                    0, thumbBounds.height, new Color(162, 162, 162));
        }
        g2.setPaint(arcRectPaint);
        g2.fill(arcRect);
        //画滚动条矩形边框
        g2.setColor(new Color(150, 150, 150));
        g2.draw(arcRect);
        //画滚动条矩形内圈边框
        g2.setColor(new Color(230, 230, 230));
        Rectangle bounds = arcRect.getBounds();
        g2.drawRoundRect(bounds.x + 1, bounds.y + 1, bounds.width - 2, bounds.height - 2, (int) ARC_NUMBER, (int) ARC_NUMBER);

        g2.translate(-thumbBounds.x, -thumbBounds.y);
        g2.setPaint(oldPaint);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2 = (Graphics2D) g;
        Paint foregroundRectPaint = null;
        Paint backgroupRectPaint = null;
        Paint oldPaint = g2.getPaint();
        //绘制滚动背景
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            foregroundRectPaint = new GradientPaint(0, 0, new Color(172, 172, 172),
                    trackBounds.width, 0, new Color(225, 225, 225));
            backgroupRectPaint = new GradientPaint(0, 0, new Color(216, 216, 216),
                    trackBounds.width, 0, new Color(172, 172, 172));
        } else {
            foregroundRectPaint = new GradientPaint(0, 0, new Color(172, 172, 172),
                    0, trackBounds.height, new Color(225, 225, 225));
            backgroupRectPaint = new GradientPaint(0, 0, new Color(216, 216, 216),
                    0, trackBounds.height, new Color(172, 172, 172));
        }
        g2.setPaint(backgroupRectPaint);
        g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        g2.setPaint(foregroundRectPaint);
        g2.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width - 1, trackBounds.height - 1, (int) ARC_NUMBER, (int) ARC_NUMBER);
        g2.setColor(new Color(162, 162, 162));
        g2.drawRoundRect(trackBounds.x, trackBounds.y, trackBounds.width - 1, trackBounds.height - 1, (int) ARC_NUMBER, (int) ARC_NUMBER);

        g2.setPaint(oldPaint);

        //始终没有进入这两个判断方法，通过单独调用它们中的任意一个即刻明白这两个方法的含义
        if (trackHighlight == DECREASE_HIGHLIGHT) {
            paintDecreaseHighlight(g);
        } else if (trackHighlight == INCREASE_HIGHLIGHT) {
            paintIncreaseHighlight(g);
        }
    }

    @Override
    protected void paintDecreaseHighlight(Graphics g) {
    }

    @Override
    protected void paintIncreaseHighlight(Graphics g) {
    }

    @Override
    protected javax.swing.JButton createDecreaseButton(int orientation) {
        return new BasicArrowButton(orientation) {

            @Override
            public void paint(Graphics g) {
                GradientPaint backgroupRectPaint = null;
                if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                    backgroupRectPaint = new GradientPaint(0, 0, new Color(216, 216, 216),
                            getWidth(), 0, new Color(172, 172, 172));
                } else {
                    backgroupRectPaint = new GradientPaint(0, 0, new Color(216, 216, 216),
                            0, getHeight(), new Color(172, 172, 172));
                }
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(backgroupRectPaint);
                g2.fillRect(0, 0, getWidth(), getHeight());
                // Draw the arrow
                IScrollBarUI.this.paintTriangle(g2, getSize(), direction);
            }
        };
    }

    public void paintTriangle(Graphics2D g2, Dimension buttonSize,
            int direction) {
        int x, y, w, h, size;

        w = buttonSize.width;
        h = buttonSize.height;
        size = Math.min((h - 4) / 3, (w - 4) / 3);
        size = Math.max(size, 2);
        x = (w - size) / 2;
        y = (h - size) / 2;

        Color oldColor = g2.getColor();
        int mid, i, j;

        j = 0;
        size = Math.max(size, 2) + 2;
        mid = (size / 2) - 1;

        g2.translate(x, y);
        g2.setColor(Color.BLACK);
        switch (direction) {
            case NORTH:
                for (i = 0; i < size; i++) {
                    g2.drawLine(mid - i, i, mid + i, i);
                }
                break;
            case SOUTH:
                j = 0;
                for (i = size - 1; i >= 0; i--) {
                    g2.drawLine(mid - i, j, mid + i, j);
                    j++;
                }
                break;
            case WEST:
                for (i = 0; i < size; i++) {
                    g2.drawLine(i, mid - i, i, mid + i);
                }
                break;
            case EAST:
                j = 0;
                for (i = size - 1; i >= 0; i--) {
                    g2.drawLine(j, mid - i, j, mid + i);
                    j++;
                }
                break;
        }
        g2.translate(-x, -y);
        g2.setColor(oldColor);
    }

    @Override
    protected javax.swing.JButton createIncreaseButton(int orientation) {

        return new BasicArrowButton(orientation) {

            @Override
            public void paint(Graphics g) {
                GradientPaint backgroupRectPaint = null;
                if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                    backgroupRectPaint = new GradientPaint(0, 0, new Color(216, 216, 216),
                            getWidth(), 0, new Color(172, 172, 172));
                } else {
                    backgroupRectPaint = new GradientPaint(0, 0, new Color(216, 216, 216),
                            0, getHeight(), new Color(172, 172, 172));
                }
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(backgroupRectPaint);
                g2.fillRect(0, 0, getWidth(), getHeight());
                IScrollBarUI.this.paintTriangle(g2, getSize(), direction);
            }
        };
    }
}