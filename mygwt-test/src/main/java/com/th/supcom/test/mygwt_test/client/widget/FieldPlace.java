package com.th.supcom.test.mygwt_test.client.widget;


import com.extjs.gxt.ui.client.widget.Component;

/**
 * 在field排版时位置信息 参考dms组提供的工具
 * 
 */
public class FieldPlace
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

    private Integer m_colSpan;

    private Component m_field;

    private String m_labelAlian;

    private Integer m_labelWidth;

    public FieldPlace (final Component field, final Integer colSpan, final String labelAlian, final Integer labelWidth, final Integer col)
    {
        super ();
        m_field = field;
        m_colSpan = colSpan;
        m_labelAlian = labelAlian;
        m_labelWidth = labelWidth;
        m_col = col;
    }

    /**
     * @return the col
     */
    public Integer getCol ()
    {
        return this.m_col;
    }

    /**
     * @return the colSpan
     */
    public Integer getColSpan ()
    {
        return this.m_colSpan;
    }

    /**
     * @return the field
     */
    public Component getField ()
    {
        return this.m_field;
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

    /**
     * @param col the col to set.
     */
    public void setCol (final Integer col)
    {
        m_col = col;
    }

    /**
     * @param colSpan the colSpan to set.
     */
    public void setColSpan (final Integer colSpan)
    {
        m_colSpan = colSpan;
    }

    /**
     * @param field the field to set.
     */
    public void setField (final Component field)
    {
        m_field = field;
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
}

