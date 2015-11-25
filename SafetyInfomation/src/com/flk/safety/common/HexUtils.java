/*
 */
package com.flk.safety.common;

import java.io.UnsupportedEncodingException;

public class HexUtils
{
	/**
	 * 1 byte string notation
	 */
	public static String toHexByte( byte v )
	{
		return	Integer.toString( (v>>4 & 0x0f), 16 ) +
				Integer.toString( (v & 0x0f), 16 );
	}

	/**
	 * 2 byte short string notation
	 */
	public static String toHexByte( short v )
	{
		return	HexUtils.toHexByte( (byte)(v>>8 & 0xff) ) +
				HexUtils.toHexByte( (byte)(v & 0xff) );
	}

	/**
	 * 4 byte integer string notation
	 */
	public static String toHexByte( int v )
	{
		return	HexUtils.toHexByte( (short)(v>>16 & 0xffff) ) +
				HexUtils.toHexByte( (short)(v & 0xffff) );
	}

	/**
	 * 8 byte long string notation
	 */
	public static String toHexByte( long v )
	{
		return	HexUtils.toHexByte( (int)(v>>32 & 0xffffffff) ) +
				HexUtils.toHexByte( (int)(v & 0xffffffff) );
	}

	/**
	 * Byte notation.
	 */
	public static String toHexByte( byte[] b, int off, int len )
	{
		StringBuffer	sb = new StringBuffer();

		if (len > b.length-off) len = b.length-off;

		for (int i=0; i<len; i++)
		{
			sb.append( HexUtils.toHexByte(b[i]) );
		}
		return sb.toString();
	}

	public static String toHexByte( byte[] b )
	{
		return HexUtils.toHexByte( b, 0, b.length );
	}

	//////////////////////////////////////////////////////////////////
	public static String getHexView( byte[] buf )
	{
		return HexUtils.getHexView( buf, 0, buf.length );
	}


	public static String getHexView( byte[] buf, int off, int len )
	{
		StringBuffer	sb = new StringBuffer();
		byte[]			disp = new byte[20];
    	int     		i, j;

	    for (i=0, j=0; i<len; i++)
    	{
			disp[j++] = buf[off+i] < 0x20 ? 0x20 : buf[off+i];

			sb.append( HexUtils.toHexByte(buf[off+i]) + " " );
        	if ((i+1)%16==0)
        	{
				try { sb.append( "| " + new String(disp, "8859_1") + "\n"); }
				catch(UnsupportedEncodingException uee)
				{	sb.append( "| " + new String(disp) + "\n"); }

				for (j=0; j<20; j++) disp[j] = (byte)0x00;
				j = 0;
       		}
			else if ((i+1)%8==0)
			{
				sb.append(' ');
			}
    	}

		if (len%16!=0)
		{
			while (i%16 != 0)
			{
				if (i%8==0) sb.append(' ');
				sb.append("   ");
				i++;
			}
			try { sb.append( "| " + new String(disp, "8859_1") + "\n"); }
			catch(UnsupportedEncodingException uee)
			{	sb.append( "| " + new String(disp) + "\n"); }
		}

    	return sb.toString();
	}

	/**
	 * ELFHash function.
	 */
	public static int ELFHash( String key )
	{
		int h = 0, g;
		int		len;
		int i;
		
		if (null == key) key = "";

		len = key.length();
		for (i = 0; i <len; i++)
		{
			h = (h<<4 ) + (key.charAt(i) & 0xff);
			g = h & (int)0xF0000000L;
    
			if ( g != 0 ) h ^= g >> 24;
    		h &= ~g;
  		}
  	
		return h;
	}
}
