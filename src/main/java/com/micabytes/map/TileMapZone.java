/*
 * Copyright 2013 MicaByte Systems
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.micabytes.map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.micabyte.android.BaseObject;
import com.micabytes.gfx.ImageHandler;

/**
 * Zone superclass for TileMap and HexMap
 *
 * @author micabyte
 */
public class TileMapZone extends BaseObject {

  protected TileMapZone(String id, String name) {
    super(id, name, 0);
  }

  /**
   * Get the width of a tile
   */
  public int getWidth(Context context) {
    return ImageHandler.getInstance(context).get(getValue()).getWidth();
  }

  /**
   * Get the height of a tile
   */
  public int getHeight(Context context) {
    return ImageHandler.getInstance(context).get(getValue()).getHeight();
  }

  /**
   * Draw the base bitmap of the tile on a canvas
   */
  public void drawBase(Context context, Canvas canvas, Rect tileRect, Rect destRect, Paint paint) {
    canvas.drawBitmap(ImageHandler.getInstance(context).get(getValue()), tileRect, destRect, paint);
  }


}
