/**
 * Copyright 2009-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.javacrumbs.fjdemo.parallel2.parallel;

import javax.swing.*;
import java.awt.*;

import static net.javacrumbs.fjdemo.parallel2.parallel.QueueBox.TASK_COLORS;

public class ThreadBox extends JPanel {
    private final WorkCanvas workCanvas;
    private final JLabel label;
    private Task task;
    private static final int COLUMN_WIDTH = 100;
    private static final int TASK_HEIGHT = 10;

    public ThreadBox() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        workCanvas = new WorkCanvas();
        workCanvas.setPreferredSize(new Dimension(COLUMN_WIDTH, TASK_HEIGHT));
        label = new JLabel();
        label.setPreferredSize(new Dimension(COLUMN_WIDTH, 40));
        add(label);
        add(workCanvas);
        setPreferredSize(new Dimension(COLUMN_WIDTH * 2, 40));
    }

    public void setTask(Task task, String message) {
        this.task = task;
        label.setText(message);
    }


    private class WorkCanvas extends JPanel {


        public WorkCanvas() {
            setBorder(BorderFactory.createLineBorder(Color.black));
            setPreferredSize(new Dimension(COLUMN_WIDTH, TASK_HEIGHT));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (task != null) {
                g.setColor(TASK_COLORS[task.getTaskId() % TASK_COLORS.length]);
                g.drawRect(task.getStart(), 0, task.getWidth(), TASK_HEIGHT);
            }
        }
    }
}