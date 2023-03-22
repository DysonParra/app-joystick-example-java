/*
 * @fileoverview    {PolyJoystickComponentActionSetter}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementación realizada.
 * @version 2.0     Documentación agregada.
 */
package com.project.dev.example.joystick.desktop.setter;

import com.project.dev.example.joystick.desktop.buttonaction.ButtonAction;
import com.project.dev.example.joystick.desktop.frame.ExampleFrame;
import com.project.dev.joystick.button.GenericButtonActionListener;
import com.project.dev.joystick.name.generic.GenericJoystick;
import com.project.dev.joystick.name.poly.PolyJoystick;
import javax.swing.JLabel;

/**
 * TODO: Definición de {@code PolyJoystickComponentActionSetter}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class PolyJoystickComponentActionSetter extends GenericJoystickComponentActionSetter<ExampleFrame, JLabel> {

    /**
     * TODO: Definición de {@code PolyJoystickComponentActionSetter}.
     *
     * @param component      es un componente gráfico que será controlado por el joystick.
     * @param window         es el JFrame al que pertenece el componente gráfico.
     * @param windowWidth    es el ancho máximo de la ventana donde se moverá el componente gráfico.
     * @param windowHeight   Es el alto máximo de la ventana donde se moverá el componente gráfico.
     * @param windowDivision Indica en cuanto se dividirá la ventana (cuantas imagenes cabrán a lo
     *                       alto).
     */
    public PolyJoystickComponentActionSetter(JLabel component, ExampleFrame window, int windowWidth, int windowHeight, int windowDivision) {
        super(component, window, windowWidth, windowHeight, windowDivision);
    }

    /**
     * FIXME: Definición de {@code setButtonActions}. Asigna acciones a un joystick.
     *
     * @param joystick es el joystick que controlará el componente.
     * @throws java.lang.Exception si no es posible asignar acciones al joystick indicado.
     */
    @Override
    public void setButtonActions(GenericJoystick joystick) throws Exception {
        if (!(joystick instanceof PolyJoystick))
            throw new Exception("This method is only allowed for PolyJoystick");

        joystick.getButton(PolyJoystick.BUTTON_START_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonStartAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonStartAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonStartAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonStartAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });

        joystick.getButton(PolyJoystick.BUTTON_SELECT_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonSelectAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonSelectAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonSelectAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonSelectAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });

        joystick.getButton(PolyJoystick.BUTTON_LEFT_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonMoveLeftAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonMoveLeftAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonMoveLeftAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonMoveLeftAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });

        joystick.getButton(PolyJoystick.BUTTON_RIGHT_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonMoveRightAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonMoveRightAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonMoveRightAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonMoveRightAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });

        joystick.getButton(PolyJoystick.BUTTON_UP_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonMoveUpAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonMoveUpAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonMoveUpAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonMoveUpAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });

        joystick.getButton(PolyJoystick.BUTTON_DOWN_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonMoveDownAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonMoveDownAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonMoveDownAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonMoveDownAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });

        joystick.getButton(PolyJoystick.BUTTON_SQUARE_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonLeftAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonLeftAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonLeftAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonLeftAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });

        joystick.getButton(PolyJoystick.BUTTON_CIRCLE_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonRightAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonRightAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonRightAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonRightAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });

        joystick.getButton(PolyJoystick.BUTTON_TRIANGLE_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonUpAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonUpAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonUpAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonUpAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });

        joystick.getButton(PolyJoystick.BUTTON_EKS_NAME).setOnActionListener(new GenericButtonActionListener() {
            @Override
            public void onTyped() {
                ButtonAction.runButtonDownAction(PolyJoystickComponentActionSetter.this, BUTTON_TYPED);
            }

            @Override
            public void onPressed() {
                ButtonAction.runButtonDownAction(PolyJoystickComponentActionSetter.this, BUTTON_PRESSED);
            }

            @Override
            public void onReleased() {
                ButtonAction.runButtonDownAction(PolyJoystickComponentActionSetter.this, BUTTON_RELEASED);
            }

            @Override
            public void onUnpressed() {
                ButtonAction.runButtonDownAction(PolyJoystickComponentActionSetter.this, BUTTON_UNPRESSED);
            }
        });
    }
}
