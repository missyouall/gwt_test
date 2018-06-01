/*
 * $Id$
 *
 * Copyright ( c ) 2015 XuNuo Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of XuNuo
 * Corporation ("Confidential Information").  You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with XuNuo Corporation or a XuNuo
 * authorized reseller (the "License Agreement"). XuNuo may make changes to the
 * Confidential Information from time to time. Such Confidential Information may
 * contain errors.
 *
 * EXCEPT AS EXPLICITLY SET FORTH IN THE LICENSE AGREEMENT, XuNuo DISCLAIMS ALL
 * WARRANTIES, COVENANTS, REPRESENTATIONS, INDEMNITIES, AND GUARANTEES WITH
 * RESPECT TO SOFTWARE AND DOCUMENTATION, WHETHER EXPRESS OR IMPLIED, WRITTEN OR
 * ORAL, STATUTORY OR OTHERWISE INCLUDING, WITHOUT LIMITATION, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, TITLE, NON-INFRINGEMENT AND FITNESS FOR A
 * PARTICULAR PURPOSE. XuNuo DOES NOT WARRANT THAT END USER'S USE OF THE
 * SOFTWARE WILL BE UNINTERRUPTED, ERROR FREE OR SECURE.
 *
 * XuNuo SHALL NOT BE LIABLE TO END USER, OR ANY OTHER PERSON, CORPORATION OR
 * ENTITY FOR INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY OR CONSEQUENTIAL
 * DAMAGES, OR DAMAGES FOR LOSS OF PROFITS, REVENUE, DATA OR USE, WHETHER IN AN
 * ACTION IN CONTRACT, TORT OR OTHERWISE, EVEN IF XuNuo HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES. XuNuo' TOTAL LIABILITY TO END USER SHALL NOT
 * EXCEED THE AMOUNTS PAID FOR THE XuNuo SOFTWARE BY END USER DURING THE PRIOR
 * TWELVE (12) MONTHS FROM THE DATE IN WHICH THE CLAIM AROSE.  BECAUSE SOME
 * STATES OR JURISDICTIONS DO NOT ALLOW LIMITATION OR EXCLUSION OF CONSEQUENTIAL
 * OR INCIDENTAL DAMAGES, THE ABOVE LIMITATION MAY NOT APPLY TO END USER.
 *
 * Copyright version 2.0
 */
package  com.th.supcom.test.mygwt_test.client.widget.tool;

import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.th.supcom.test.mygwt_test.client.widget.FieldPanel;

public class StuConditionFieldSet extends FieldSet
{
    private final String m_headerText;
    private final FieldPanel m_panel;

    public StuConditionFieldSet (String headerText, FieldPanel panel)
    {
        m_headerText = headerText;
        m_panel = panel;

        initUI ();
    }
    /**
     * 初始化UI
     */
    private void initUI ()
    {
        setHeading (m_headerText);
        add (m_panel);
    }

}
