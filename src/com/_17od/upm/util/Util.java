/*
 * $Id$
 * 
 * Universal Password Manager
 * Copyright (C) 2005-2010 Adrian Smith
 *
 * This file is part of Universal Password Manager.
 *   
 * Universal Password Manager is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Universal Password Manager is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Universal Password Manager; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com._17od.upm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;


public class Util {

    /**
     * Left pad an integer to a given length with the given
     * character 
     * @param i The integer to pad
     * @param length The length to pad it to
     * @param c The character to do the padding with
     * @return A padded version of the integer
     */
    public static String lpad(int i, int length, char c) {
        StringBuffer buf = new StringBuffer(String.valueOf(i));
        while (buf.length() < length) {
            buf.insert(0, c);
        }
        return buf.toString();
    }

    
    public static ImageIcon loadImage(String name) {
        URL imageURL = Util.class.getResource("images/" + name);
        return new ImageIcon(imageURL);
    }


    public static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
    
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
    
}
