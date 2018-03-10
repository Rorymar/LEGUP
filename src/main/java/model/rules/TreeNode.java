package model.rules;

import model.gameboard.Board;

import java.util.ArrayList;

public class TreeNode extends TreeElement
{
    private ArrayList<TreeTransition> parents;
    private ArrayList<TreeTransition> children;
    private boolean isRoot;

    /**
     * TreeNode Constructor - Creates a tree node whenever a rule has been made
     *
     * @param board board associated with this tree node
     */
    public TreeNode(Board board)
    {
        super(TreeElementType.NODE);
        this.board = board;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.isRoot = false;
    }

    /**
     * Determines if this tree node leads to a contradiction. Every path from this tree node
     * must lead to a contradiction including all of its children
     *
     * @return true if this tree node leads to a contradiction, false otherwise
     */
    public boolean leadsToContradiction()
    {
        if(children.size() == 0)
        {
            return false;
        }
        else
        {
            boolean leadsToContra = true;
            for(TreeTransition child: children)
            {
                if(child.getChildNode() == null)
                {
                    leadsToContra &= child.getRule() != null && child.getRule().getRuleType() == RuleType.CONTRADICTION && child.isCorrect();
                }
                else
                {
                    leadsToContra &= child.getChildNode().leadsToContradiction();
                }
            }
            return leadsToContra;
        }
    }

    /**
     * Adds a parent to this tree node
     *
     * @param parent parent to add
     */
    public void addParent(TreeTransition parent)
    {
        parents.add(parent);
    }

    /**
     * Removes a parent to this tree node
     *
     * @param parent parent to remove
     */
    public void removeParent(TreeTransition parent)
    {
        parents.remove(parent);
    }

    /**
     * Determines if the specified tree node is a parent of this node
     *
     * @param parent tree node that could be a parent
     * @return true if the specified tree node is a parent of this node, false otherwise
     */
    public boolean isParent(TreeNode parent)
    {
        return children.contains(parent);
    }

    /**
     * Adds a child to this tree node
     *
     * @param child child to add
     */
    public void addChild(TreeTransition child)
    {
        children.add(child);
    }

    /**
     * Removes a child to this tree node
     *
     * @param child child to remove
     */
    public void removeChild(TreeTransition child)
    {
        children.remove(child);
    }

    /**
     * Determines if the specified tree node is a child of this node
     *
     * @param child tree node that could be a child
     * @return true if the specified tree node is a child of this node, false otherwise
     */
    public boolean isChild(TreeNode child)
    {
        return children.contains(child);
    }

    /**
     * Gets the TreeNode's parent
     *
     * @return the TreeNode's parents
     */
    public ArrayList<TreeTransition> getParents()
    {
        return parents;
    }

    /**
     * Sets the TreeNode's parent
     *
     * @param parent the TreeNode's parents
     */
    public void setParents(ArrayList<TreeTransition> parent)
    {
        this.parents = parent;
    }

    /**
     * Gets the TreeNode's children
     *
     * @return the TreeNode's children
     */
    public ArrayList<TreeTransition> getChildren()
    {
        return children;
    }

    /**
     * Sets the TreeNode's children
     *
     * @param children the TreeNode's children
     */
    public void setChildren(ArrayList<TreeTransition> children)
    {
        this.children = children;
    }

    /**
     * Is this node the root of the tree
     *
     * @return true if this node is the root of the tree, false otherwise
     */
    public boolean isRoot()
    {
        return isRoot;
    }

    /**
     * Sets the root of the tree
     *
     * @param isRoot true if this node is the root of the tree, false otherwise
     */
    public void setRoot(boolean isRoot)
    {
        this.isRoot = isRoot;
    }
}
