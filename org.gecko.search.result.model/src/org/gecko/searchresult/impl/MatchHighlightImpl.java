/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.searchresult.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Match Highlight</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.MatchHighlightImpl#getStartOffset <em>Start Offset</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchHighlightImpl#getEndOffset <em>End Offset</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchHighlightImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchHighlightImpl#getHighlightedText <em>Highlighted Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MatchHighlightImpl extends MinimalEObjectImpl.Container implements MatchHighlight {
	/**
	 * The default value of the '{@link #getStartOffset() <em>Start Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int START_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartOffset() <em>Start Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartOffset()
	 * @generated
	 * @ordered
	 */
	protected int startOffset = START_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndOffset() <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int END_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndOffset() <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOffset()
	 * @generated
	 * @ordered
	 */
	protected int endOffset = END_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getHighlightedText() <em>Highlighted Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighlightedText()
	 * @generated
	 * @ordered
	 */
	protected static final String HIGHLIGHTED_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHighlightedText() <em>Highlighted Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighlightedText()
	 * @generated
	 * @ordered
	 */
	protected String highlightedText = HIGHLIGHTED_TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchHighlightImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.MATCH_HIGHLIGHT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartOffset() {
		return startOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartOffset(int newStartOffset) {
		int oldStartOffset = startOffset;
		startOffset = newStartOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_HIGHLIGHT__START_OFFSET, oldStartOffset, startOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndOffset() {
		return endOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndOffset(int newEndOffset) {
		int oldEndOffset = endOffset;
		endOffset = newEndOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_HIGHLIGHT__END_OFFSET, oldEndOffset, endOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_HIGHLIGHT__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHighlightedText() {
		return highlightedText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighlightedText(String newHighlightedText) {
		String oldHighlightedText = highlightedText;
		highlightedText = newHighlightedText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_HIGHLIGHT__HIGHLIGHTED_TEXT, oldHighlightedText, highlightedText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.MATCH_HIGHLIGHT__START_OFFSET:
				return getStartOffset();
			case SearchResultPackage.MATCH_HIGHLIGHT__END_OFFSET:
				return getEndOffset();
			case SearchResultPackage.MATCH_HIGHLIGHT__TEXT:
				return getText();
			case SearchResultPackage.MATCH_HIGHLIGHT__HIGHLIGHTED_TEXT:
				return getHighlightedText();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SearchResultPackage.MATCH_HIGHLIGHT__START_OFFSET:
				setStartOffset((Integer)newValue);
				return;
			case SearchResultPackage.MATCH_HIGHLIGHT__END_OFFSET:
				setEndOffset((Integer)newValue);
				return;
			case SearchResultPackage.MATCH_HIGHLIGHT__TEXT:
				setText((String)newValue);
				return;
			case SearchResultPackage.MATCH_HIGHLIGHT__HIGHLIGHTED_TEXT:
				setHighlightedText((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SearchResultPackage.MATCH_HIGHLIGHT__START_OFFSET:
				setStartOffset(START_OFFSET_EDEFAULT);
				return;
			case SearchResultPackage.MATCH_HIGHLIGHT__END_OFFSET:
				setEndOffset(END_OFFSET_EDEFAULT);
				return;
			case SearchResultPackage.MATCH_HIGHLIGHT__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case SearchResultPackage.MATCH_HIGHLIGHT__HIGHLIGHTED_TEXT:
				setHighlightedText(HIGHLIGHTED_TEXT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SearchResultPackage.MATCH_HIGHLIGHT__START_OFFSET:
				return startOffset != START_OFFSET_EDEFAULT;
			case SearchResultPackage.MATCH_HIGHLIGHT__END_OFFSET:
				return endOffset != END_OFFSET_EDEFAULT;
			case SearchResultPackage.MATCH_HIGHLIGHT__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case SearchResultPackage.MATCH_HIGHLIGHT__HIGHLIGHTED_TEXT:
				return HIGHLIGHTED_TEXT_EDEFAULT == null ? highlightedText != null : !HIGHLIGHTED_TEXT_EDEFAULT.equals(highlightedText);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (startOffset: ");
		result.append(startOffset);
		result.append(", endOffset: ");
		result.append(endOffset);
		result.append(", text: ");
		result.append(text);
		result.append(", highlightedText: ");
		result.append(highlightedText);
		result.append(')');
		return result.toString();
	}

} //MatchHighlightImpl
