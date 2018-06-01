package com.th.supcom.test.mygwt_test.client.widget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.th.supcom.test.mygwt_test.client.common.StuEvents;
import com.th.supcom.test.mygwt_test.client.model.StuBaseDataModel;
import com.th.supcom.test.mygwt_test.client.model.StuDisplay;
import com.th.supcom.test.mygwt_test.client.model.StuModel;
import com.th.supcom.test.mygwt_test.client.service.StuRpc;
import com.th.supcom.test.mygwt_test.client.service.StuRpcAsync;
import com.th.supcom.test.mygwt_test.client.widget.tool.StuBuilder;
import com.th.supcom.test.mygwt_test.client.widget.tool.StuConditionFieldSet;
import com.th.supcom.test.mygwt_test.client.widget.tool.StuFormWindow;

public class StuPanel extends ContentPanel{
	// 页面数据构造器
		private final StuBuilder builder = new StuBuilder();
		// 表格
		private Grid<StuDisplay> grid;

		// 数据访问
		private StuRpcAsync stuRpc=GWT.create(StuRpc.class);

		public StuPanel() {
			//设置是否可见
			this.setHeaderVisible(false);
			//设置布局方式
			setLayout(new BorderLayout());
		}

		/**
		 * 页面初始化
		 */
		protected void onRender(Element parent, int index) {
			super.onRender(parent, index);

			BorderLayoutData top = new BorderLayoutData(LayoutRegion.NORTH, 60);
			top.setMargins(new Margins(0, 20, 5, 20));

			// 查询表单
			FieldPanel fp = new FieldPanel();
			final TextField<String> name = new TextField<String>();
			name.setFieldLabel("姓名");
			//是否可以为空默认是true
			name.setAllowBlank(true);
			fp.addCol(name, 2, null, null);
			final ComboBox<StuBaseDataModel> sex = new ComboBox<StuBaseDataModel>();
			sex.setFieldLabel("性别");
			ListStore<StuBaseDataModel> sexs = new ListStore<StuBaseDataModel>();
			sexs.add(new StuBaseDataModel("1", "男"));
			sexs.add(new StuBaseDataModel("2", "女"));
			sex.setDisplayField("displayName");
			sex.setStore(sexs);
			fp.addCol(sex, 2, null, null);
			final DateField createTime = new DateField();
			createTime.setPropertyEditor (new DateTimePropertyEditor ("yyyy-MM-dd"));
			createTime.setBorders(true);
			createTime.setFieldLabel("开始创建日期");
			createTime.setMaxValue(new Date());
			createTime.setFormatValue(true);
			createTime.setValue(new Date());
			createTime.setInputStyleAttribute ("color", "blue");
			createTime.setEnabled(true);
			fp.addCol(createTime, 2, null, null);
			
			/*LabelField labelField = new LabelField("----");
			fp.addCol(labelField, 0, "L", 50);
			
			final DateField createTimeEnd = new DateField();
			createTimeEnd.setPropertyEditor (new DateTimePropertyEditor ("yyyy-MM-dd"));
			createTimeEnd.setBorders(true);
			createTimeEnd.setMaxValue(new Date());
			createTimeEnd.setFormatValue(true);
			createTimeEnd.setValue(new Date());
			createTimeEnd.setInputStyleAttribute ("color", "blue");
			createTimeEnd.setEnabled(true);
			createTimeEnd.setFieldLabel("");
			fp.addCol(createTimeEnd, 2, "R", null);*/
			// 查询按钮
			Button queryBtn = new Button("搜索");
			fp.addCol(new Text(), 1, null, null);
			fp.addCol(queryBtn, 1, null, null);
			fp.addCol(new Text(), 1, null, null);
			queryBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					StuModel model=new StuModel();
					model.setName(name.getValue());
					if(sex.getValue()!=null)
					{
						model.setSex(Integer.parseInt(sex.getValue().getItemCode()));
					}
					model.setCreateTime(createTime.getValue());
					builder.loadGridData(StuPanel.this, model);
				}
			});
			fp.newRow();

			StuConditionFieldSet ecfs = new StuConditionFieldSet("搜索条件", fp);
			fp.setHeight(60);
			add(ecfs, top);

			// 数据查询显示
			BorderLayoutData center = new BorderLayoutData(LayoutRegion.CENTER);
			center.setMargins(new Margins(0));
			ContentPanel cp = new ContentPanel();
			cp.setHeaderVisible(false);

			cp.setTopComponent(createToolBar());// 放入工具栏
			cp.add(createGrid());// 放入表格
			add(cp, center);
		}

		public final ColumnConfig createColumnConfig(final String id,
				final String header, final int width,
				final HorizontalAlignment alignment, final boolean isDigit,
				CellEditor cellEditor, GridCellRenderer cellRenderer) {
			final ColumnConfig column = new ColumnConfig();
			column.setId(id);
			column.setHeader(header);
			column.setWidth(width);
			column.setSortable(false);

			column.setAlignment(alignment);

			if (null != cellEditor) {
				column.setEditor(cellEditor);
			}
			
			if (null!= cellRenderer ){
	            column.setRenderer(cellRenderer);
	        }

			return column;
		}

		/**
		 * 数据展示表格
		 * 
		 * @return
		 */
		public Grid<StuDisplay> createGrid() {
			List<ColumnConfig> columns = new ArrayList<ColumnConfig>();

			// 选择框
			CheckBoxSelectionModel<StuDisplay> m_sm = new CheckBoxSelectionModel<StuDisplay>();
			m_sm.setSelectionMode(SelectionMode.SINGLE);
			
			GridCellRenderer<StuDisplay> sexRenderer=new GridCellRenderer<StuDisplay>(){
	            @Override
	            public  Object render(StuDisplay model,String property,ColumnData config,int rowIndex,int colIndex,
	                                  ListStore<StuDisplay> store,Grid<StuDisplay> grid){

	                String sex = model.getSex();
	                if("男".equals(sex)){
	                    return "<p style='color:red;'>男</p>" ;
	                }else if("女".equals(sex)){
	                    return "<p style='color:green;'>女</p>";
	                }
	                return  null;
	            }

	        };
	        
	        
			columns.add(m_sm.getColumn());
			columns.add(createColumnConfig("id", "编号", 50, HorizontalAlignment.CENTER, false, null,null));
			columns.add(createColumnConfig("name", "姓名", 100, HorizontalAlignment.CENTER, false, null,null));
			columns.add(createColumnConfig("sex", "性别", 100, HorizontalAlignment.CENTER, false, null,sexRenderer));
			columns.add(createColumnConfig("age", "年龄", 100, HorizontalAlignment.CENTER, false, null,null));
			columns.add(createColumnConfig("createTime", "创建日期", 100, HorizontalAlignment.CENTER, false, null,null));

			ColumnModel cm = new ColumnModel(columns);
			//定义显示的对象类型
			grid = new Grid<StuDisplay>(builder.getM_listStore(), cm);
			grid.setLoadMask(true);
			grid.setBorders(true);
			grid.setStyleAttribute("borderTop", "none");
			grid.setSelectionModel(m_sm);
			grid.addPlugin(m_sm);
			grid.setStripeRows(true);
			grid.setColumnLines(true);
			grid.setColumnReordering(true);
			grid.getView().setForceFit(true);
			grid.setHeight(500);

			builder.loadGridData(StuPanel.this, new StuModel());// 加载GRID数据
			return grid;
		}

		/**
		 * 工具栏
		 * 
		 * @return
		 */
		public ToolBar createToolBar() {
			ToolBar tb = new ToolBar();
			tb.setBorders(false);
			Button addBtn = new Button("添加");
			addBtn.setTitle("添加按钮");
			tb.add(addBtn);
			addBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					StuFormWindow stuFormW = new StuFormWindow(new StuDisplay());
					stuFormW.show();
					stuFormW.addListener(StuEvents.S_GRID_DATA_LOAD,
						new Listener<AppEvent>() {
							@Override
							public void handleEvent(AppEvent be) {
								builder.loadGridData(StuPanel.this,new StuModel());
							}

						});
				}

			});
			tb.add(new SeparatorToolItem());//分隔符
			Button updateBtn = new Button("修改");
			tb.add(updateBtn);
			updateBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					List<StuDisplay> models=grid.getSelectionModel().getSelectedItems();
					if(models.size()==0)
					{
						MessageBox.alert("提示", "请选择要修改的项", null);
					}
					else if(models.size()==1)
					{
						 
						StuFormWindow stuFormW = new StuFormWindow(models.get(0));
						stuFormW.show();
						stuFormW.addListener(StuEvents.S_GRID_DATA_LOAD,
							new Listener<AppEvent>() {
								@Override
								public void handleEvent(AppEvent be) {
									builder.loadGridData(StuPanel.this,new StuModel());
								}

							});
					}
				}
			});

			Button delBtn = new Button("删除");
			tb.add(new SeparatorToolItem());//分隔符
			tb.add(delBtn);
			delBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					List<StuDisplay> models=grid.getSelectionModel().getSelectedItems();
					if (models.size()==0) {
						MessageBox.alert("提示", "请选择需要删除的项", null);
						return;
					}
					
					MessageBox.confirm("提示", "是否需要删除该员工信息",
							new Listener<MessageBoxEvent>() {
								@Override
								public void handleEvent(MessageBoxEvent be) {
									final Button btn = be.getButtonClicked();
									if ("是".equals(btn.getText())) {
										// 获取用户选择删除的行
										StuDisplay selectedData = grid.getSelectionModel().getSelectedItem();
										StuDisplay model = (StuDisplay) selectedData;
										stuRpc.delete(model.getId(),new AsyncCallback<Integer>() {
													@Override
													public void onFailure(
															Throwable caught) {
														MessageBox.alert("提示","删除失败"+ caught.getMessage(),	null);
													}
													@Override
													public void onSuccess(
															Integer result) {
														if (result > 0) {
															Info.display("提示","删除成功");
															builder.loadGridData(StuPanel.this,new StuModel());
																	
														} else {
															MessageBox.alert("提示","删除失败", null);
																	
														}

													}
												});
									}
								}

							});
				}

			});
			tb.add(new SeparatorToolItem());//分隔符
			Button testBtn = new Button("测试");
			tb.add(testBtn);
			testBtn.addSelectionListener(new SelectionListener<ButtonEvent>(){

				@Override
				public void componentSelected(ButtonEvent ce) {
					// TODO Auto-generated method stub
					MessageBox.info("测试提示", "测试信息", null);
				}
				
			});
			return tb;
		}
}
