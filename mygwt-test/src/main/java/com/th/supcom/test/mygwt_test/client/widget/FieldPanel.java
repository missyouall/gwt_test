package com.th.supcom.test.mygwt_test.client.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.Element;

/**
 * 列布局简化面板 参考dms组提供的工具
 * 
 */
public class FieldPanel extends LayoutContainer
{
    /** 公司版权信息. */
    public static final String copyright = "Copyright 2014, TH Supcom Corporation";
    /** 提交路径. */
    public static final String SCC_BRANCH = "$URL$";
    /** 提交日期. */
    public static final String SCC_LAST_MODIFICATION_DATE = "$Date$";
    /** 最终修改人员. */
    public static final String SCC_LAST_MODIFIER_NAME = "$Author$";
    /** 最终版本号. */
    public static final String SCC_REVISION = "$Revision$";

    private Integer m_col;
    private final Map <Integer, Integer> m_colLabelWidth = new HashMap <Integer, Integer> ();

    private List <FieldPlace> m_fieldPlace;

    private String m_labelAlian;

    private Integer m_labelWidth;

    private String m_paddingRight;

    private final List <List <FieldPlace>> m_rowPlace = new ArrayList <List <FieldPlace>> ();

    public FieldPanel ()
    {
        m_fieldPlace = new ArrayList <FieldPlace> ();
        m_labelAlian = "R";
        m_labelWidth = 100;
        m_col = 0;

        // setLayout (new ColumnLayout ());
        setLayout (new FormLayout ());
    }

    /**
     * 添加一个component
     * 
     * @param component 组件
     * @return
     */
    public void addCol (final Component component, final Integer colSpan, final String labelAlian, final Integer labelWidth)
    {
        if (component == null)
        {
            return;
        }
        final FieldPlace dp = new FieldPlace (component, getNotNull (colSpan), labelAlian, labelWidth, m_col);
        if (labelWidth == null)
        {
            dp.setLabelWidth (m_labelWidth);
        }
        if (labelAlian == null)
        {
            dp.setLabelAlian (m_labelAlian);
        }
        m_col += getNotNull (colSpan);
        m_fieldPlace.add (dp);
    }

    /**
     * 设置查询面板LayoutContainer样式
     * 
     * @param labelWidth
     * @return
     */
    private LayoutContainer createLayoutContaner (final FieldPlace filedPlace)
    {
        final FormLayout layout = new FormLayout ();
        final Integer labelWidth = filedPlace.getLabelWidth ();
        layout.setLabelWidth (labelWidth);
        if ("L".equals (filedPlace.getLabelAlian ()))
        {
            layout.setLabelAlign (LabelAlign.LEFT);
        }
        if ("T".equals (filedPlace.getLabelAlian ()))
        {
            layout.setLabelAlign (LabelAlign.TOP);
        }
        if ("R".equals (filedPlace.getLabelAlian ()))
        {
            layout.setLabelAlign (LabelAlign.RIGHT);
        }
        final LayoutContainer container = new LayoutContainer (layout);
        container.add (filedPlace.getField (), new FormData ("100%"));
        if (m_paddingRight == null)
        {
            container.setStyleAttribute ("paddingRight", "5px");
        }
        else
        {
            container.setStyleAttribute ("paddingRight", m_paddingRight);
        }
        return container;
    };

    /**
     * @return the fieldPlace
     */
    public List <FieldPlace> getFieldPlace ()
    {
        return this.m_fieldPlace;
    }

    /**
     * @return the labelAlian
     */
    public String getLabelAlian ()
    {
        return this.m_labelAlian;
    }

    /**
     * @return the labelWidth
     */
    public Integer getLabelWidth ()
    {
        return this.m_labelWidth;
    }

    private Integer getLabelWidth (final FieldPlace filedPlace, final Integer col)
    {
        final Integer width = m_colLabelWidth.get (col);
        if (width == null)
        {
            return filedPlace.getLabelWidth ();
        }
        return width;
    }

    private Integer getMaxCol (final List <FieldPlace> lists)
    {
        Integer cols = 0;
        for (int i = 0; i < lists.size (); i++)
        {
            final FieldPlace filedPlace = lists.get (i);
            cols += filedPlace.getColSpan ();
        }
        return cols;
    }

    private Integer getNotNull (final Integer value)
    {
        if (value == null)
        {
            return Integer.valueOf (1);
        }
        return value;
    }

    /**
     * 得到一行的面板
     * 
     * @param lists
     * @return
     */
    private LayoutContainer getRowPanel (final List <FieldPlace> lists)
    {
        final LayoutContainer container = new LayoutContainer ();
        container.setLayout (new ColumnLayout ());
        final Double dpl = 1.0 / getMaxCol (lists);
        for (int i = 0; i < lists.size (); i++)
        {
            final FieldPlace filedPlace = lists.get (i);
            filedPlace.setLabelWidth (getLabelWidth (filedPlace, filedPlace.getCol ()));
            container.add (createLayoutContaner (filedPlace), new ColumnData (dpl * filedPlace.getColSpan ()));
        }
        return container;
    }

    /**
     * @return the rowPlace
     */
    public List <List <FieldPlace>> getRowPlace ()
    {
        return this.m_rowPlace;
    }

    /**
     * 将转addCol方法加入的组件作为一行添加到Panel
     */
    public void newRow ()
    {
        m_rowPlace.add (m_fieldPlace);
        m_fieldPlace = new ArrayList <FieldPlace> ();
        m_col = 0;
    }

    @Override
    public void onRender (final Element parent, final int index)
    {
        super.onRender (parent, index);
        // 添加组件到面板
        for (int i = 0; i < m_rowPlace.size (); i++)
        {
            add (getRowPanel (m_rowPlace.get (i)), new FormData ("100%"));
        }
    }

    /**
     * 设置某一列的Label宽度
     */
    public void setColWidth (final Integer col, final Integer colWidth)
    {
        m_colLabelWidth.put (col, colWidth);
    }

    /**
     * @param labelAlian the labelAlian to set.
     */
    public void setLabelAlian (final String labelAlian)
    {
        m_labelAlian = labelAlian;
    }

    /**
     * @param labelWidth the labelWidth to set.
     */
    public void setLabelWidth (final Integer labelWidth)
    {
        m_labelWidth = labelWidth;
    }

    /**
     * 设置每一个区域的PaddingRight
     * 
     * @param s
     * @return
     */
    public void setPaddingRight (final String s)
    {
        m_paddingRight = s;
    }
}
