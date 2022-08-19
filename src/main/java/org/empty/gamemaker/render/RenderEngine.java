package org.empty.gamemaker.render;

import org.empty.gamemaker.GraphicObject;

public interface RenderEngine {

    void initialize();
    void render(GraphicObject object);

    void refresh();

    void close();
}
